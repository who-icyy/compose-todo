package com.cobu.tasks.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tasks::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract  fun taskDao() : TaskDao
}
