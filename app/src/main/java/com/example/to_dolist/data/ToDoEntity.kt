package com.example.to_dolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mytodos")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    var isDone : Boolean = false
)
