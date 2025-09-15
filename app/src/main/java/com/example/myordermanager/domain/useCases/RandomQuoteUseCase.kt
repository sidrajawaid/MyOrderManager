package com.example.myordermanager.domain.useCases

import com.example.myordermanager.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

    operator fun invoke() = flow {
        quoteRepository.getRandomQuote().let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }

}