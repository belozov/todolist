package com.example.to_dolist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.Update
import androidx.room.Delete


@Dao
interface TodoDao {

    @Query("SELECT * FROM mytodos")
    fun getAllTodos(): Flow<List<ToDoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insert(todo: ToDoEntity)

    @Update
    suspend fun update(todo: ToDoEntity)

    @Delete
    suspend fun delete(todo: ToDoEntity)
}