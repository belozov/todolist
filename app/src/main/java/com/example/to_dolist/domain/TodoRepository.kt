package com.example.to_dolist.domain

import com.example.to_dolist.data.ToDoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodo(): Flow<List<Todo>>
    suspend fun addTodo(todo: ToDoEntity)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
}
