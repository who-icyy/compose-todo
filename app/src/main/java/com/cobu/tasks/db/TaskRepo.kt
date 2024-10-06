package com.cobu.tasks.db

import androidx.lifecycle.LiveData

class TaskRepo(private  val taskDao: TaskDao) {
    val readAllData: LiveData<List<Task>> = taskDao.readAllData()

    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }
}