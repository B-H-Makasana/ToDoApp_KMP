package com.example.todoapp.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(onClick: () -> Unit, modifier: Modifier,text: String) {
    Button(
        {
            onClick.invoke()
        }, modifier = modifier.wrapContentSize().padding(horizontal = 50.dp, vertical = 30.dp),
        colors = ButtonColors(
            containerColor = Color.Blue,
            contentColor = Color.White,
            disabledContentColor = Color.Blue,
            disabledContainerColor = Color.White
        )
    ) {
        Text(text, fontSize = 20.sp)
    }
}

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium.copy(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun DescriptionText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 22.sp
        ),
        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun HeaderView(text: String,modifier: Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium.copy(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(25.dp),
        textAlign = TextAlign.Center
    )
}

