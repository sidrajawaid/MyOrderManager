package com.example.myordermanager.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myordermanager.domain.models.AllQuotesDC
import com.example.myordermanager.domain.models.HomeQuotesDC
import com.example.myordermanager.domain.useCases.AllQuotesUseCase
import com.example.myordermanager.domain.useCases.RandomQuoteUseCase
import com.example.myordermanager.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val allQuotesUseCase: AllQuotesUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase
) : ViewModel() {


    var quotesData = MutableStateFlow<NetworkUIState<HomeQuotesDC>>(NetworkUIState.LOADING())
        private set


    init {
        getQuotes()
    }


    private fun getQuotes() {
        quotesData.tryEmit(NetworkUIState.LOADING())
        allQuotesUseCase().combine(randomQuoteUseCase()){ quotesList: List<AllQuotesDC.QuoteDC>?, randomQuote: AllQuotesDC.QuoteDC? ->
            quotesData.tryEmit(NetworkUIState.SUCCESS(HomeQuotesDC(randomQuote = randomQuote, allQuotesList = quotesList)))
        }.launchIn(viewModelScope)
    }

}