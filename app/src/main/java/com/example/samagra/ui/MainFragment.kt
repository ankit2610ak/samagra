package com.example.samagra.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.samagra.R
import com.example.samagra.core.BaseFragment
import com.example.samagra.core.BaseViewModel
import com.example.samagra.ui.navigation.CommentsNavigation
import com.example.samagra.ui.navigation.PhotosNavigation
import com.example.samagra.ui.navigation.PostsNavigation
import com.example.samagra.ui.navigation.TodosNavigation
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : BaseFragment() {

    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, MainViewModelFactory()).get(MainViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()

        comments_btn.setOnClickListener {
            viewModel.getComments()
        }
        photos_btn.setOnClickListener {
            viewModel.getPhotos()
        }
        todos_btn.setOnClickListener {
            viewModel.getTodos()
        }
        posts_btn.setOnClickListener {
            viewModel.getPosts()
        }
        viewModel.timerStatusLiveData.observe(this, {
            Toast.makeText(baseActivity, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.errorToastLiveData.observe(this, {
            Toast.makeText(baseActivity, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.commentsLiveData.observe(this, {
            when (it) {
                is CommentsNavigation.CommentsEnd -> {
                    val currentTime = System.currentTimeMillis()
                    comments_end.text = "End: " + setLiveTime(currentTime)


                }
                is CommentsNavigation.CommentsEndSave -> {
                    val currentTime = System.currentTimeMillis()
                    comments_end_save.text = "EndSave: " + setLiveTime(currentTime)


                }
                is CommentsNavigation.CommentsStart -> {
                    val currentTime = System.currentTimeMillis()
                    comments_start.text = "Start: " + setLiveTime(currentTime)


                }
                is CommentsNavigation.CommentsStartSave -> {
                    val currentTime = System.currentTimeMillis()
                    comments_start_save.text = "StartSave: " + setLiveTime(currentTime)


                }
            }
        })

        viewModel.photosLiveData.observe(this, {
            when (it) {
                is PhotosNavigation.PhotosEnd -> {
                    val currentTime = System.currentTimeMillis()
                    photos_end.text = "End: " + setLiveTime(currentTime)

                }
                is PhotosNavigation.PhotosEndSave -> {
                    val currentTime = System.currentTimeMillis()
                    photos_end_save.text = "End Save: " + setLiveTime(currentTime)

                }
                is PhotosNavigation.PhotosStart -> {
                    val currentTime = System.currentTimeMillis()
                    photos_start.text = "Start: " + setLiveTime(currentTime)

                }
                is PhotosNavigation.PhotosStartSave -> {
                    val currentTime = System.currentTimeMillis()
                    photos_start_save.text = "Start Save: " + setLiveTime(currentTime)


                }
            }
        })

        viewModel.todosLiveData.observe(this, {
            when (it) {
                is TodosNavigation.TodosEnd -> {
                    val currentTime = System.currentTimeMillis()
                    todos_end.text = "End: " + setLiveTime(currentTime)

                }
                is TodosNavigation.TodosEndSave -> {
                    val currentTime = System.currentTimeMillis()
                    todos_end_save.text = "End Save: " + setLiveTime(currentTime)


                }
                is TodosNavigation.TodosStart -> {
                    val currentTime = System.currentTimeMillis()
                    todos_start.text = "Start: " + setLiveTime(currentTime)

                }
                is TodosNavigation.TodosStartSave -> {
                    val currentTime = System.currentTimeMillis()
                    todos_start_save.text = "Start Save: " + setLiveTime(currentTime)

                }
            }
        })

        viewModel.postsLiveData.observe(this, {
            when (it) {
                is PostsNavigation.PostsEnd -> {
                    val currentTime = System.currentTimeMillis()
                    posts_end.text = "End: " + setLiveTime(currentTime)

                }
                is PostsNavigation.PostsEndSave -> {
                    val currentTime = System.currentTimeMillis()
                    posts_end_save.text = "End Save: " + setLiveTime(currentTime)


                }
                is PostsNavigation.PostsStart -> {
                    val currentTime = System.currentTimeMillis()
                    posts_start.text = "Start: " + setLiveTime(currentTime)


                }
                is PostsNavigation.PostsStartSave -> {
                    val currentTime = System.currentTimeMillis()
                    posts_start_save.text = "Start: " + setLiveTime(currentTime)


                }
            }
        })

    }


    override fun getTitle(): String {
        return getString(R.string.samagra)
    }

    @SuppressLint("SimpleDateFormat")
    private fun setLiveTime(liveTime: Long): String? {
        val date = Calendar.getInstance()
        date.timeInMillis = liveTime
        val simpleDateTimeFormatter = SimpleDateFormat("hh: mm: ss a")
        return simpleDateTimeFormatter.format(date.time)

    }

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun getResourceFile(): Int {
        return R.layout.fragment_main
    }
}