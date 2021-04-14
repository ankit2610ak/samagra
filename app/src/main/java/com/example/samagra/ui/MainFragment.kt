package com.example.samagra.ui

import android.os.Bundle
import android.view.View
import com.example.samagra.R
import com.example.samagra.core.BaseFragment
import com.example.samagra.core.BaseViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun onPageInitialize() {

    }

    private fun onPageLoading() {
        error_view.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
        comments_box.visibility = View.GONE
        comments_btn.visibility = View.GONE
        photos_box.visibility = View.GONE
        photos_btn.visibility = View.GONE
        todos_box.visibility = View.GONE
        todos_btn.visibility = View.GONE
        posts_box.visibility = View.GONE
        posts_btn.visibility = View.GONE
    }

    private fun onPageLoadSuccess() {
        error_view.visibility = View.GONE
        progress_bar.visibility = View.GONE
        comments_box.visibility = View.VISIBLE
        comments_btn.visibility = View.VISIBLE
        photos_box.visibility = View.VISIBLE
        photos_btn.visibility = View.VISIBLE
        todos_box.visibility = View.VISIBLE
        todos_btn.visibility = View.VISIBLE
        posts_box.visibility = View.VISIBLE
        posts_btn.visibility = View.VISIBLE
    }

    private fun onPageLoadComplete() {
        //do nothing
    }

    private fun onPageLoadError(error: String) {
        error_view.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
        comments_box.visibility = View.GONE
        comments_btn.visibility = View.GONE
        photos_box.visibility = View.GONE
        photos_btn.visibility = View.GONE
        todos_box.visibility = View.GONE
        todos_btn.visibility = View.GONE
        posts_box.visibility = View.GONE
        posts_btn.visibility = View.GONE
        error_view.setError(error)
        error_view.setRetry {
            viewModel.onRetryClicked()
        }
    }

    override fun getTitle(): String {
        return getString(R.string.samagra)
    }

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun getResourceFile(): Int {
        return R.layout.fragment_main
    }
}