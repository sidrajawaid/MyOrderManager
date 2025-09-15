package com.example.myordermanager.data.repositoryImpl


import com.example.myordermanager.domain.models.AllQuotesDC
import com.example.myordermanager.domain.repository.QuoteRepository
import com.example.myordermanager.presentation.remote.ApiInterface
import retrofit2.Response

import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
): QuoteRepository {
    override suspend fun getAllQuotes(): Response<AllQuotesDC> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomQuote(): Response<AllQuotesDC.QuoteDC> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleQuote(id: String): Response<AllQuotesDC.QuoteDC> {
        TODO("Not yet implemented")
    }


}