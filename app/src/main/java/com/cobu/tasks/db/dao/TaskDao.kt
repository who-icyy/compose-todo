package com.cobu.tasks.db.dao

import androidx.room.*
import com.cobu.tasks.db.entities.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY dueDate ASC")
    suspend fun getAllTasks(): List<Task>

    @Query("SELECT * FROM task_table WHERE isCompleted = :isCompleted ORDER BY dueDate ASC")
    suspend fun getTasksByCompletionStatus(isCompleted: Boolean): List<Task>
}
