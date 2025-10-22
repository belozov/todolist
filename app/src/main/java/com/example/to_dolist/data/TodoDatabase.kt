package com.example.to_dolist.data
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoEntity::class], version = 1, exportSchema = false)

abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}