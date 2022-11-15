package com.srizan.list

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

fun NavGraphBuilder.listScreen(onRepoItemClick: () -> Unit) {
    composable("list") {
        ListScreen(onRepoItemClick)
    }
}

fun NavController.navigateToListScreen(navOptions: NavOptions? = null){
    this.navigate("list", navOptions)
}

@Composable
internal fun ListScreen(
    //uiState: ListUiState,
    onRepoItemClick: () -> Unit
) {
    RepoItem()
}

@Preview
@Composable
internal fun RepoItem() {
    ConstraintLayout {
        val (
            avatar,
            userName,
            repoName,
            fullName,
            description,


        ) = createRefs()

        Image(
            imageVector = Icons.Default.Person,
            contentDescription = "",
            modifier = Modifier.constrainAs(avatar) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        Text(text = "Srizan",
            modifier = Modifier.constrainAs(userName) {
                start.linkTo(avatar.end)
                top.linkTo(parent.top)

            }
        )
        Text(text = "Repo Name",
            modifier = Modifier.constrainAs(repoName) {
                start.linkTo(avatar.end)
                top.linkTo(userName.bottom)

            })
        Text(text = "Full Name",
            modifier = Modifier.constrainAs(fullName) {
                top.linkTo(repoName.bottom)

            })
        Text(text = "Description",
            modifier = Modifier.constrainAs(description) {
                top.linkTo(fullName.bottom)

            })

    }
}