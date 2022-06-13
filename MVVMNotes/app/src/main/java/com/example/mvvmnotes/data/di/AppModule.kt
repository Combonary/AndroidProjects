package com.example.mvvmnotes.data.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmnotes.data.TaskDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataBase(app: Application, callback: TaskDataBase.Callback) =
        Room.databaseBuilder(app, TaskDataBase::class.java, "Task_DB")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()

    @Provides
    fun provideTaskDao(db: TaskDataBase) = db.taskDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideAppScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope