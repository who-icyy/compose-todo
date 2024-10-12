package com.cobu.tasks.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(task: String, isCompleted: Boolean) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = task)
        Checkbox(
            checked = isCompleted,
            onCheckedChange = null // You can handle the checkbox logic here if needed
        )
    }
}

@Composable
fun ToDoListContent(modifier: Modifier = Modifier) {
    val tasks = listOf(
        mapOf("task" to "Buy groceries", "is_completed" to false),
        mapOf("task" to "Finish homework", "is_completed" to true),
        mapOf("task" to "Clean the house", "is_completed" to false),
        mapOf("task" to "Prepare dinner", "is_completed" to true),
        mapOf("task" to "Read a book", "is_completed" to false)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tasks.size) { index ->
            TaskItem(task = tasks[index]["task"] as String, isCompleted = tasks[index]["is_completed"] as Boolean)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("To-Do List") }
            )
        }
    ) { paddingValues ->
        ToDoListContent(modifier = Modifier.padding(paddingValues))
    }}