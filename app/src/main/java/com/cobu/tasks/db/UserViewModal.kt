package com.cobu.tasks.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModal(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Task>>
    private val repo: TaskRepo

    init {
        val taskDao = TaskDataBase.getDatabase(application).taskDao()
        repo = TaskRepo(taskDao)
        readAllData = repo.readAllData

    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repo.addTask(task)
        }
    }
}