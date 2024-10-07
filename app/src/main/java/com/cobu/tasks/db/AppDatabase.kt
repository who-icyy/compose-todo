package com.cobu.tasks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cobu.tasks.db.dao.TaskDao
import com.cobu.tasks.db.entities.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
