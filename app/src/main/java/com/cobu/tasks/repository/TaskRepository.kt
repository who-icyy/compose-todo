package com.cobu.tasks.repository

import androidx.lifecycle.LiveData
import com.cobu.tasks.db.TaskDao
import com.cobu.tasks.models.Task

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) {
        taskDao.insertTask(task)
    }
}
