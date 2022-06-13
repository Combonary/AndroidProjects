package com.example.mvvmnotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmnotes.data.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase: RoomDatabase() {
    abstract fun taskDao():TaskDao

    class Callback @Inject constructor(private val database: Provider<TaskDataBase>, @ApplicationScope private val applicationScope: CoroutineScope): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            database.get()
            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Revisit topic"))
            }
        }
    }
}