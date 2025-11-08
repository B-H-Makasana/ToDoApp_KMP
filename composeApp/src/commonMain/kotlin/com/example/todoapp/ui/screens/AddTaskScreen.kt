package com.example.todoapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.datetime.*

@OptIn(ExperimentalMaterial3Api::class)
object AddTaskScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
        var selectedTime by remember { mutableStateOf<LocalTime?>(null) }
        var showDatePicker by remember { mutableStateOf(false) }
        var showTimePicker by remember { mutableStateOf(false) }

        val formattedDateTime = remember(selectedDate, selectedTime) {
            if (selectedDate != null && selectedTime != null) {
                "${selectedDate.toString()} ${selectedTime.toString()}"
            } else "Select Date & Time"
        }
//        val datePickerState = rememberDatePickerState(initialSelectedDateMillis =)


        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Add Task",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Text("←")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Title field
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Description field
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )

                // Date-Time picker
                OutlinedTextField(
                    value = formattedDateTime,
                    onValueChange = {},
                    label = { Text("Date & Time") },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showDatePicker = true }
                )

                // Submit button
                Button(
                    onClick = {
                        val localDate = selectedDate
                        val localTime = selectedTime
                        if (localDate != null && localTime != null) {
                            val dateTime = LocalDateTime(
                                localDate.year,
                                localDate.month,
                                localDate.dayOfMonth,
                                localTime.hour,
                                localTime.minute
                            )
//                        onTaskAdded(title, description, dateTime)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = title.isNotBlank() && description.isNotBlank() &&
                            selectedDate != null && selectedTime != null
                ) {
                    Text("Submit")
                }
            }
        }

        if (showDatePicker) {
            val datePickerState = rememberDatePickerState()

            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        val selectedMillis = datePickerState.selectedDateMillis
                        if (selectedMillis != null) {
                            val instant = Instant.fromEpochMilliseconds(selectedMillis)
                            selectedDate =
                                instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
                            showDatePicker = false
                            showTimePicker = true // open time picker after picking date
                        } else {
                            showDatePicker = false
                        }
                    }) {
                        androidx.compose.material3.Text("Next")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        androidx.compose.material3.Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

// Time Picker Dialog
        if (showTimePicker) {
            val timeState = rememberTimePickerState()

            AlertDialog(
                onDismissRequest = { showTimePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        selectedTime = LocalTime(timeState.hour, timeState.minute)
                        showTimePicker = false
                    }) {
                        androidx.compose.material3.Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showTimePicker = false }) {
                        androidx.compose.material3.Text("Cancel")
                    }
                },
                text =
             {
                TimePicker(state = timeState)
            })
        }
    }
}