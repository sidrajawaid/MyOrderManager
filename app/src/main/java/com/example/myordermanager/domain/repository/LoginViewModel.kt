package com.example.myordermanager.domain.repository

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myordermanager.presentation.GoogleSignInManager
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginState>(LoginState.Idle)
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun signInUser(apiKey: String) {
        viewModelScope.launch {
            _uiState.value = LoginState.Loading

            try {
                GoogleSignInManager.signInWithGoogle(
                    context = getApplication(context),
                    apiKey = apiKey,
                    onSuccess = { result ->
                        _uiState.value = LoginState.Success(result.displayName)
                        // Save to database, navigate to home, etc.
                    },
                    onError = { error ->
                        _uiState.value = LoginState.Error(error.message ?: "Sign-in failed")
                    }
                )
            } catch (e: Exception) {
                _uiState.value = LoginState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val userName: String) : LoginState()
    data class Error(val message: String) : LoginState()
}