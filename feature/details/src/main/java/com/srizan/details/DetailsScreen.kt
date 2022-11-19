package com.srizan.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import com.srizan.common.design.ErrorScreen
import com.srizan.common.design.LoadingScreen
import com.srizan.domain.model.GitHubUserDomainModel


@Composable
internal fun DetailsScreen(
    userName: String,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true, block = {
        viewModel.action(UiAction.GetUserDetails(userName))
    })

    when (val uiState = viewModel.uiState) {
        is UserDetailsUIState.ErrorState -> ErrorScreen() { viewModel.action(UiAction.GetUserDetails(userName)) }
        is UserDetailsUIState.IdleState -> {}
        is UserDetailsUIState.LoadingState -> LoadingScreen()
        is UserDetailsUIState.SuccessState -> UserDetails(user = uiState.user)
    }
}

@Composable
internal fun UserDetails(user: GitHubUserDomainModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = user.avatarUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(192.dp)
                .padding(12.dp)
                .clip(CircleShape)
        )
        Text(
            text = user.name,
            fontWeight = FontWeight.Bold
        )
        Text(text = user.login)
        Text(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp),
            text = "Bio"
        )
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Info(
                count = user.publicRepos,
                description = "Repository"
            )
            Info(
                count = user.followers,
                description = "Follower"
            )
            Info(
                count = user.following,
                description = "Following"
            )
        }
    }
}

@Composable
internal fun Info(
    modifier: Modifier = Modifier,
    count: Int = 0,
    description: String = "Desc"
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            fontWeight = FontWeight.Bold
        )
        Text(text = description)
    }
}