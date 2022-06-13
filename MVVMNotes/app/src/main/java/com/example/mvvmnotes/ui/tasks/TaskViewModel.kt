package com.example.mvvmnotes.ui.tasks

import androidx.lifecycle.ViewModel
import com.example.mvvmnotes.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private  val taskDao: TaskDao
): ViewModel() {
}