package com.srizan.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.detailsScreen() {
    composable("details") {
        DetailsScreen()
    }
}

@Composable
fun DetailsScreen() {
    Text(text = "Details")
}