import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    }
}

@Composable
fun ToDoListContent(modifier: Modifier = Modifier) {
    // Using mutableStateListOf to manage the task list state
    val tasks = remember {
        mutableStateListOf(
            mutableMapOf("task" to "Buy groceries", "is_completed" to false),
            mutableMapOf("task" to "Finish homework", "is_completed" to true),
            mutableMapOf("task" to "Clean the house", "is_completed" to false),
            mutableMapOf("task" to "Prepare dinner", "is_completed" to true),
            mutableMapOf("task" to "Read a book", "is_completed" to false)
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
