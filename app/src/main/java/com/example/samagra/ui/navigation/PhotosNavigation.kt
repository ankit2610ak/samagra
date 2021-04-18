package com.example.samagra.ui.navigation

sealed class PhotosNavigation{
    class PhotosStart : PhotosNavigation()
    class PhotosEnd : PhotosNavigation()
    class PhotosStartSave: PhotosNavigation()
    class PhotosEndSave: PhotosNavigation()
}
