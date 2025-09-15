package com.example.myordermanager.di


import com.example.myordermanager.data.repositoryImpl.QuoteRepositoryImpl
import com.example.myordermanager.domain.repository.QuoteRepository
import com.example.myordermanager.presentation.remote.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun getQuotesRepository(
        apiInterface: ApiInterface
    ): QuoteRepository = QuoteRepositoryImpl(apiInterface = apiInterface)

}