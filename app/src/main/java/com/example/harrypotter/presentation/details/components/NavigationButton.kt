package com.example.harrypotter.presentation.details.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NavigationButton(
    onClick: () -> Unit,
    icon: ImageVector
) {
    Button(
        modifier = Modifier.size(50.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(10.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.dp,
            pressedElevation = 5.dp,
            focusedElevation = 5.dp,
            hoveredElevation = 5.dp,
        ),
        onClick = { onClick() }
    ){
        Icon(imageVector = icon, contentDescription = "icon")
    }
}