package com.cobu.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.cobu.tasks.db.TaskDatabase
import com.cobu.tasks.ui.theme.TasksTheme

class MainActivity : ComponentActivity() {
    lateinit var database :TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasksTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Column {
                        Text("Hemloo")
                    }
                }
            }
        }
        database = Room.databaseBuilder(this, TaskDatabase::class.java, "tasks").build()

    }
}


