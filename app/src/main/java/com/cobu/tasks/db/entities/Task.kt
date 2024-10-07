package com.cobu.tasks.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false,
    val dueDate: Long? = null // Store as timestamp for easier sorting and comparison
)
