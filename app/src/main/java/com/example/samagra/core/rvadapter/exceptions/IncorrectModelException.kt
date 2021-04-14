package com.example.apps10x.core.rvadapter.exceptions

class IncorrectModelException : Exception() {
  init {
    printStackTrace()
  }

  override val message: String?
    get() = "This view holder does not except this model. Please correct the model this view holder is designed to handle."
}