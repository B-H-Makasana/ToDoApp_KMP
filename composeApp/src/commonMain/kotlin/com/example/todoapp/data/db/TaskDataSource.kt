package com.example.todoapp.data.db

import com.example.todoapp.data.Task

interface TaskDataSource {
    suspend fun insertTask(entity: Task)
    suspend fun getAllTask(): List<Task>
    suspend fun deleteTask(task: Task)
    suspend fun updateTask(entity: Task)
}
