package com.example.to_dolist.domain

import com.example.to_dolist.data.ToDoEntity

class AddTodoUseCase(private val todoRepository: TodoRepository) {
    suspend fun execute(title: String){
        todoRepository.addTodo(ToDoEntity(title = title, isDone = false))
    }

}