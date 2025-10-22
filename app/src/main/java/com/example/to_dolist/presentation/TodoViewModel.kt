package com.example.to_dolist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.to_dolist.data.ToDoEntity
import com.example.to_dolist.data.TodoDataRepository
import com.example.to_dolist.data.TodoDatabase
import com.example.to_dolist.domain.Todo
import com.example.to_dolist.domain.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        TodoDatabase::class.java,
        "my_todo_db"
    ).build()

    private val todoRepository: TodoRepository = TodoDataRepository(db.todoDao())

    val todos = todoRepository.getTodo()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addTodo(title: String) {
        viewModelScope.launch {
            if (title.isNotBlank()) {
                val todo = ToDoEntity(title = title)
                todoRepository.addTodo(todo)
            }
        }
    }

    fun toggleTodoDone(todo: Todo) {
        viewModelScope.launch {
            todoRepository.updateTodo(todo.copy(isDone = !todo.isDone))
        }
    }

    fun editTodo(todo: Todo, newTitle: String) {
        viewModelScope.launch {
            if (newTitle.isNotBlank()) {
                todoRepository.updateTodo(todo.copy(title = newTitle))
            }
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.deleteTodo(todo)
        }
    }
}
