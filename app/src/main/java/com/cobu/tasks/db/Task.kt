package com.cobu.tasks.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
class Tasks(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val task: String,
    val isComplete: Boolean
)