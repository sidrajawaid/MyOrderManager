package com.example.myordermanager.domain.repository

import com.example.myordermanager.domain.models.AllQuotesDC
import retrofit2.Response

interface QuoteRepository {

    suspend fun getAllQuotes(): Response<AllQuotesDC>

    suspend fun getRandomQuote(): Response<AllQuotesDC.QuoteDC>

    suspend fun getSingleQuote(id: String): Response<AllQuotesDC.QuoteDC>

}