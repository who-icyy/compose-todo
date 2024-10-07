package com.cobu.tasks.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cobu.tasks.models.Task
import com.cobu.tasks.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(taskViewModel: TaskViewModel) {
    val taskList by taskViewModel.allTasks.observeAsState(initial = emptyList())

    LazyColumn {
        items(taskList) { task ->
            TaskItem(task = task)
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Task: ${task.name}")
        Text(text = "Description: ${task.description}")
        Text(
            text = if (task.isCompleted) "Status: Completed" else "Status: Pending",
            color = if (task.isCompleted) Color.Green else Color.Red
        )
    }
}
