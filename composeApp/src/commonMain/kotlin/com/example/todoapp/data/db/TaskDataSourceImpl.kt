package com.example.todoapp.data.db

import com.example.todoapp.data.Task

class TaskDataSourceImpl(private val taskDao: TaskDao) : TaskDataSource {
    override suspend fun insertTask(entity: Task) {
        taskDao.insert(entity)
    }

    override suspend fun getAllTask(): List<Task> {
        taskDao.getAllTask()
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.delete(task)
    }

    override suspend fun updateTask(entity: Task) {
        taskDao.update(entity)
    }
}