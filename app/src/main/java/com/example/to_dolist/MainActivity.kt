package com.example.to_dolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.to_dolist.presentation.TodoViewModel
import com.example.to_dolist.userscreen.TodoScreen

class MainActivity : ComponentActivity() {
    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // ✅ переносим сюда перед контентом
        setContent {
            MaterialTheme {
                Surface {
                    TodoScreen(todoViewModel = todoViewModel)
                }
            }
        }
    }
}
