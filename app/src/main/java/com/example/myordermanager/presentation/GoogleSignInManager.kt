package com.example.myordermanager.presentation



import android.content.Context
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.NoCredentialException
import com.example.myordermanager.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

object GoogleSignInManager {

    private var credentialManager: CredentialManager? = null

    data class SignInResult(
        val displayName: String,
        val idToken: String,
        val email: String? = null
    )

    suspend fun signInWithGoogle(
        context: Context,
        apiKey: String,
        filterByAuthorizedAccounts: Boolean = false,
        onSuccess: (SignInResult) -> Unit,
        onError: (Exception) -> Unit
    ) {
        if (credentialManager == null) {
            credentialManager = CredentialManager.create(context)
        }

        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(filterByAuthorizedAccounts)
            .setServerClientId(apiKey)
            .setAutoSelectEnabled(false)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        requestSignIn(context, request, apiKey, filterByAuthorizedAccounts, onSuccess, onError)
    }

    private suspend fun requestSignIn(
        context: Context,
        request: GetCredentialRequest,
        apiKey: String,
        filterByAuthorizedAccounts: Boolean,
        onSuccess: (SignInResult) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        try {
            val credentialManager = credentialManager ?: throw IllegalStateException("CredentialManager not initialized")
            val result: GetCredentialResponse = credentialManager.getCredential(
                request = request,
                context = context,
            )
            val signInResult = handleCredentials(result.credential)
            signInResult?.let(onSuccess) ?: onError(Exception("Invalid user credentials"))
        } catch (e: Exception) {
            if (e is NoCredentialException && filterByAuthorizedAccounts) {
                // Retry without filtering by authorized accounts
                signInWithGoogle(
                    context = context,
                    apiKey = apiKey,
                    filterByAuthorizedAccounts = false,
                    onSuccess = onSuccess,
                    onError = onError
                )
            } else {
                onError(e)
            }
        }
    }

    private fun handleCredentials(credential: Credential): SignInResult? {
        return when (credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)

                        return SignInResult(
                            displayName = googleIdTokenCredential.displayName ?: "Unknown User",
                            idToken = googleIdTokenCredential.idToken,
                            email = googleIdTokenCredential.id // Adjust based on available fields
                        )
                    } catch (e: GoogleIdTokenParsingException) {
                        println("Received an invalid google id token response: $e")
                        null
                    }
                } else {
                    println("Unexpected type of credential: ${credential.type}")
                    null
                }
            }
            else -> {
                println("Unexpected type of credential: ${credential::class.java.simpleName}")
                null
            }
        }
    }

    fun clearCredentialManager() {
        credentialManager = null
    }
}