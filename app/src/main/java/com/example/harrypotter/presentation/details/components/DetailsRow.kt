package com.example.harrypotter.presentation.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsRow(
    isList: Boolean = false,
    list: List<String> = emptyList(),
    title: String,
    value: Any? = null
) {
    Row() {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isList){
            list.forEach {
                Text(
                    text = it.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        } else {
            Text(
                text = value.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Divider()
}