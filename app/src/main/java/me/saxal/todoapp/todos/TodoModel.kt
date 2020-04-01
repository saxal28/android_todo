package me.saxal.todoapp.todos

data class TodoModel(
    val name: String,
    val description: String,
    val totalToComplete: Int = 1,
    val currentCompleteTotal: Int = 0
)
