package com.example.samagra.ui.navigation

sealed class CommentsNavigation {
    class CommentsStart : CommentsNavigation()
    class CommentsEnd : CommentsNavigation()
    class CommentsStartSave: CommentsNavigation()
    class CommentsEndSave: CommentsNavigation()
}
