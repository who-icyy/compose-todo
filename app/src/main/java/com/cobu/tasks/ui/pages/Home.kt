import android.app.Dialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("To-Do List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(Icons.Default.Add, contentDescription = "Add") // You can use an icon here
            }
        }
    ) { paddingValues ->
        ToDoListContent(
            modifier = Modifier.padding(paddingValues),
            onAddTask = { showDialog ->
                // Update logic to show the dialog
                showDialog.value = true
            }
        )
    }
}

@Composable
fun ToDoListContent(modifier: Modifier = Modifier, onAddTask: (MutableState<Boolean>) -> Unit) {
    val tasks = remember {
        mutableStateListOf(
            mutableMapOf("task" to "Buy groceries", "is_completed" to false),
            mutableMapOf("task" to "Finish homework", "is_completed" to true),
            mutableMapOf("task" to "Clean the house", "is_completed" to false),
            mutableMapOf("task" to "Prepare dinner", "is_completed" to true),
            mutableMapOf("task" to "Read a book", "is_completed" to false)
        )
    }

    val showDialog = remember { mutableStateOf(false) }
    var newTask by remember { mutableStateOf("") }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Add New Task") },
            text = {
                Column {
                    TextField(
                        value = newTask,
                        onValueChange = { newTask = it },
                        label = { Text("Task Name") }
                    )
                }
            },
            confirmButton = {
                ElevatedButton(
                    onClick = {
                        if (newTask.isNotBlank()) {
                            // Add new task to the list
                            tasks.add(mutableMapOf("task" to newTask, "is_completed" to false))
                            newTask = ""
                            showDialog.value = false
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                ElevatedButton(onClick = { showDialog.value = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tasks.size) { index ->
            TaskItem(
                task = tasks[index]["task"] as String,
                isCompleted = tasks[index]["is_completed"] as Boolean,
                onCheckedChange = { isChecked ->
                    // Update the task's completion status
                    tasks[index] = tasks[index].toMutableMap().apply {
                        put("is_completed", isChecked)
                    }
                }
            )
        }
    }

    // Logic to show the dialog when FAB is clicked
    FloatingActionButton(
        onClick = { onAddTask(showDialog) },
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text("+") // You can replace this with an icon
    }
}

@Composable
fun TaskItem(task: String, isCompleted: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = task)
        Checkbox(
            checked = isCompleted,
            onCheckedChange = { isChecked ->
                onCheckedChange(isChecked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListAppPreview() {
    ToDoListApp()
}
