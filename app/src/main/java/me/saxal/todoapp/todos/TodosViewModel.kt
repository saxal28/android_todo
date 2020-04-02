package me.saxal.todoapp.todos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodosViewModel : ViewModel() {

    val todos: List<TodoModel> = listOf(
        TodoModel(name = "Save $500", description = "By saving at least $100 minumum; a month before retirement.", totalToComplete = 1),
        TodoModel(name = "Dream House", description = "Building a house in the middle of a mountain; middle of nowhere.", totalToComplete = 1),
        TodoModel(name = "Retire By 35", description = "Do something to create passive income and retire by 35.", totalToComplete = 1),
        TodoModel(name = "Help the Needy", description = "Once saved enough, try helping the one's in need.", totalToComplete = 1)
    )

    val goalsString = "${todos.count()} Goals"

    // ======================================
    // navigate to CreateTodo Screen
    // ======================================

    private val _navigateToCreate: MutableLiveData<Boolean> = MutableLiveData(false)
    val navigateToCreate:LiveData<Boolean>
        get() = _navigateToCreate

    fun pressNavigateToCreate() {
        _navigateToCreate.value = true
    }

    fun doneNavigatingToCreate() {
        _navigateToCreate.value = false
    }

}