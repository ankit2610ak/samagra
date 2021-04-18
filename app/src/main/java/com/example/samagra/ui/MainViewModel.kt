package com.example.samagra.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.samagra.core.BaseViewModel
import com.example.samagra.core.error.DataFetchState
import com.example.samagra.core.network.DataResponse
import com.example.samagra.core.network.apiResponses.CommentsResponse
import com.example.samagra.core.network.apiResponses.PhotosResponse
import com.example.samagra.core.network.apiResponses.PostsResponse
import com.example.samagra.core.network.apiResponses.TodosResponse
import com.example.samagra.ui.navigation.CommentsNavigation
import com.example.samagra.ui.navigation.PhotosNavigation
import com.example.samagra.ui.navigation.PostsNavigation
import com.example.samagra.ui.navigation.TodosNavigation

class MainViewModel(val mainPageContract: MainPageContract) : BaseViewModel() {
    val commentsLiveData = MutableLiveData<CommentsNavigation>()
    val photosLiveData = MutableLiveData<PhotosNavigation>()
    val todosLiveData = MutableLiveData<TodosNavigation>()
    val postsLiveData = MutableLiveData<PostsNavigation>()
    val errorToastLiveData = MutableLiveData<String>()
    val timerStatusLiveData = MutableLiveData<String>()

    override fun onViewCreated() {
        val t : Thread = Thread {
            Thread.sleep(5000)
        }
        t.start()
        t.join()
        Log.d("MainViewModel", "5 seconds completed")
        timerStatusLiveData.postValue("5 seconds completed")
        callApis()

    }

    private fun callApis() {
        Log.d("MainViewModel", "Api calls")
        getComments()
        getPhotos()
        getTodos()
        getPosts()
    }

    fun getComments(){
        commentsLiveData.postValue(CommentsNavigation.CommentsStart())
        mainPageContract.getComments(object : DataResponse<CommentsResponse>{
            override fun onSuccess(response: CommentsResponse) {
                commentsLiveData.postValue(CommentsNavigation.CommentsEnd())
            }

            override fun onError(error: String) {
                Log.d("MainViewModel", error)
                errorToastLiveData.postValue(error)

            }

        })
    }
    fun getPhotos(){
        photosLiveData.postValue(PhotosNavigation.PhotosStart())
        mainPageContract.getPhotos(object : DataResponse<PhotosResponse>{
            override fun onSuccess(response: PhotosResponse) {
                photosLiveData.postValue(PhotosNavigation.PhotosEnd())
            }

            override fun onError(error: String) {
                Log.d("MainViewModel", error)
                errorToastLiveData.postValue(error)

            }

        })
    }

    fun getPosts(){
        postsLiveData.postValue(PostsNavigation.PostsStart())
        mainPageContract.getPosts(object : DataResponse<PostsResponse>{
            override fun onSuccess(response: PostsResponse) {
                postsLiveData.postValue(PostsNavigation.PostsEnd())
            }

            override fun onError(error: String) {
                Log.d("MainViewModel", error)
                errorToastLiveData.postValue(error)

            }

        })
    }

    fun getTodos(){
        todosLiveData.postValue(TodosNavigation.TodosStart())
        mainPageContract.getTodos(object : DataResponse<TodosResponse>{
            override fun onSuccess(response: TodosResponse) {
                todosLiveData.postValue(TodosNavigation.TodosEnd())
            }

            override fun onError(error: String) {
                Log.d("MainViewModel", error)
                errorToastLiveData.postValue(error)

            }

        })
    }
}