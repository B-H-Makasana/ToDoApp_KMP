package com.example.todoapp.data

data class Task(
    val title: String,
    val description: String,
    val dateTime: Long = 0L,
    val displayTime: String
)