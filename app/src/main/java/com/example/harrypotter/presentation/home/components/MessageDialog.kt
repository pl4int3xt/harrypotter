package com.example.harrypotter.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.harrypotter.presentation.home.HomeScreenViewModel

@Composable
fun MessageDialog(
    viewModel: HomeScreenViewModel,
    message: String
) {
    Dialog(
        onDismissRequest = { viewModel.messageDialogState = false },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = message)
                Text(
                    modifier = Modifier.clickable { viewModel.getCharacters() },
                    text = "Refresh",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 25.sp
                )
            }
        }
    }
}