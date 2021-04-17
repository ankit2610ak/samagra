package com.example.samagra.ui.navigation

sealed class PostsNavigation {
    class PostsStart : PostsNavigation()
    class PostsEnd : PostsNavigation()
    class PostsStartSave : PostsNavigation()
    class PostsEndSave : PostsNavigation()
}
