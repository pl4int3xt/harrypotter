package com.example.harrypotter.presentation.home.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    TextField(value = "", onValueChange = {})
}

@Preview
@Composable
fun SearchBarPrev() {
    SearchBar()
}