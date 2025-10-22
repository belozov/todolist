package com.example.to_dolist.data

import com.example.to_dolist.domain.Todo
import com.example.to_dolist.domain.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoDataRepository(private val dao:TodoDao): TodoRepository {
    override fun getTodo(): Flow<List<Todo>> {
      return dao.getAllTodos().map {list ->
          list.map {entity ->
              Todo(
                  id = entity.id,
                  title = entity.title,
                  isDone = entity.isDone
              )
          }
      }
    }

    override suspend fun addTodo(todo: ToDoEntity) {
        dao.insert(ToDoEntity(title = todo.title, isDone = todo.isDone))
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.update(ToDoEntity(id = todo.id, title = todo.title, isDone = todo.isDone))
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.delete(ToDoEntity(id = todo.id, title = todo.title, isDone = todo.isDone))
    }


}