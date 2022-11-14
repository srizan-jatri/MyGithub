package com.srizan.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.listScreen() {
    composable("list") {
        ListScreen()
    }
}

@Composable
fun ListScreen() {
    Text(text = "List Screen")
}

@Composable
fun RepoItem() {


}