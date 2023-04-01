package com.example.harrypotter.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.harrypotter.presentation.home.HomeScreenEvents
import com.example.harrypotter.presentation.home.HomeScreenViewModel

@Composable
fun FilterDialog(
    viewModel: HomeScreenViewModel
) {
    Dialog(
        onDismissRequest = { viewModel.filterDialogState = false },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Filter",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Text(text = "Character name")
                    Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = viewModel.isSearchingByCharacterName,
                        onCheckedChange = { viewModel.onEvent(HomeScreenEvents.OnIsSearchingByCharacterNameChecked(it)) }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Text(text = "House name")
                    Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = !viewModel.isSearchingByCharacterName,
                        onCheckedChange = { viewModel.onEvent(HomeScreenEvents.OnIsSearchingByCharacterNameChecked(it)) }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    TextButton(
                        onClick = {
                            viewModel.filterDialogState = false
                            viewModel.isSearchingByCharacterName = !viewModel.isSearchingByCharacterName },
                    ){ Text(text = "Cancel") }
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        onClick = { viewModel.filterDialogState = false },
                    ){ Text(text = "Ok") }
                }
            }
        }
    }
}