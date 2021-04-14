package com.example.samagra.core.network.feature

object SamagraDataFactory {

    fun get(): SamagraDataContract {
        return SamagraApiService()
    }
}