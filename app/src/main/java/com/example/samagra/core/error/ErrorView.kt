package com.example.samagra.core.error

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.samagra.core.network.StandardizedError
import com.example.samagra.R
import kotlinx.android.synthetic.main.widget_error_view.view.*

class ErrorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {


  private var standardError: StandardizedError? = null
  init {
    View.inflate(context, R.layout.widget_error_view, this)
    visibility = View.INVISIBLE
  }

  /**
   * sets the error in the error view
   * @param error the error to be rendered on the error view
   */
  fun setError(error: StandardizedError) {
    this.standardError = error
    placeholderImage.setImageDrawable(
        ContextCompat.getDrawable(context, error.icon ?: R.drawable.placeholder_no_internet))
    errorText.text = error.displayError
  }
  fun setError(error: String){
    placeholderImage.setImageDrawable(
      ContextCompat.getDrawable(context,  R.drawable.placeholder_no_internet))
  }

  fun setRetry(listener: View.OnClickListener) {
    retryButton.visibility = View.VISIBLE
    if(standardError?.responseCode == 204)
      retryButton.visibility = View.GONE
    retryButton.setOnClickListener(listener)
  }

  fun setButtonText(buttonText: String){
    retryButton.text = buttonText
  }
}