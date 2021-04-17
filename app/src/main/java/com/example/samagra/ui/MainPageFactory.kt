package com.example.samagra.ui

import com.example.samagra.core.network.feature.SamagraDataFactory

object MainPageFactory {
    fun get(): MainPageContract{
        return MainRepository(SamagraDataFactory.get())
    }
}