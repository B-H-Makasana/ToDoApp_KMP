package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.todoapp.data.Task
import com.example.todoapp.ui.common.HeaderView
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.plus_small
import todoapp.composeapp.generated.resources.task_list_screen_header
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit

object TaskListScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val sampleTasks = remember {
//            listOf(
//                Task("Buy Groceries", "Milk, Bread, Eggs", displayTime = "iuwew"),
//                Task("Meeting with Team", "Discuss project roadmap", displayTime = "yrytrf"),
//                Task("Workout", "Leg day at gym", displayTime = "7675")
//            )
        }

        Scaffold(
            topBar = {
                HeaderView(stringResource(Res.string.task_list_screen_header), Modifier)
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    navigator.push(AddTaskScreen)
                }) {
                    Icon(
                        painter = painterResource(Res.drawable.plus_small),
                        modifier = Modifier.size(50.dp),
                        contentDescription = "Add Task"
                    )
                }
            }
        ) { pa ->
//            TaskListScreen(sampleTasks, Modifier.padding(pa))
        }
    }

    @Composable
    fun TaskCard(task: Task, modifier: Modifier = Modifier) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = task.displayTime,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {
//                        onUpdate(task)
                    }) {
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "Update")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {
//                        onDelete(task)
                    }) {
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {
//                        onDone(task)
                    }) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "Done")
                    }
                }
            }
        }
    }

    // --- Task List Screen ---
    @Composable
    fun TaskListScreen(tasks: List<Task>, modifier: Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(tasks) { task ->
                    TaskCard(task = task)
                }
            }
        }
    }
}
