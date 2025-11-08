package com.example.todoapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(item: Task)

    @Query("SELECT * FROM Task")
    fun getAllTask(): Flow<List<Task>>

    @Update
    suspend fun update(item: Task)

    @Delete
    suspend fun delete(item: Task)
}