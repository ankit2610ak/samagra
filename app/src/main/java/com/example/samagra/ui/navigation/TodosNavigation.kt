package com.example.samagra.ui.navigation

sealed class TodosNavigation{
    class TodosStart : TodosNavigation()
    class TodosEnd : TodosNavigation()
    class TodosStartSave: TodosNavigation()
    class TodosEndSave: TodosNavigation()
}
