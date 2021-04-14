package com.example.samagra.core.error

sealed class DataFetchState {
  class Init : DataFetchState()
  class Loading : DataFetchState()
  class Success : DataFetchState()
  class Complete : DataFetchState()
  class Error(val error: String) : DataFetchState()

}