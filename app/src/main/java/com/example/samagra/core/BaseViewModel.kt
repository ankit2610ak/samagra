package com.example.samagra.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(){

    abstract fun onViewCreated()

}