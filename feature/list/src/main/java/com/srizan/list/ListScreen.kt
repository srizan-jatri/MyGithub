package com.srizan.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import com.srizan.common.design.ErrorScreen
import com.srizan.common.design.LoadingScreen
import com.srizan.domain.model.RepoDomainModel

fun NavGraphBuilder.listScreen(onRepoItemClick: (String) -> Unit) {
    composable("list") {
        ListScreen(onRepoItemClick)
    }
}

@Composable
internal fun ListScreen(
    onRepoItemClick: (String) -> Unit, viewModel: ListViewModel = hiltViewModel()
) {
    when (val uiState = viewModel.uiState) {
        is RepoListUIState.ErrorState -> ErrorScreen(uiState.message) { viewModel.action(UiAction.GetRepoList) }
        is RepoListUIState.IdleState -> {}
        is RepoListUIState.LoadingState -> LoadingScreen()
        is RepoListUIState.SuccessState -> RepoList(
            list = uiState.repoList, onRepoItemClick = onRepoItemClick
        )
    }
}

@Composable
internal fun RepoList(
    list: List<RepoDomainModel>, onRepoItemClick: (String) -> Unit = {}
) {
    LazyColumn {
        items(list) { repo ->
            RepoItem(
                repo = repo, onRepoItemClick = onRepoItemClick
            )
            Divider()
        }
    }
}

@Composable
internal fun RepoItem(
    repo: RepoDomainModel, onRepoItemClick: (String) -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {onRepoItemClick(repo.owner.login)})
            .padding(16.dp)
    ) {

        val (avatarRf, userNameRf, repoNameRf, fullNameRf, descriptionRf, infoRowRf) = createRefs()

        AsyncImage(model = repo.owner.avatarUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(avatarRf) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .size(92.dp)
                .padding(12.dp)
                .clip(CircleShape))

        Text(text = repo.owner.login, modifier = Modifier.constrainAs(userNameRf) {
            start.linkTo(avatarRf.end)
            top.linkTo(avatarRf.top)
        })
        Text(text = repo.name, modifier = Modifier.constrainAs(repoNameRf) {
            start.linkTo(userNameRf.start)
            top.linkTo(userNameRf.bottom)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
        Text(text = repo.fullName, modifier = Modifier.constrainAs(fullNameRf) {
            top.linkTo(avatarRf.bottom)
        })
        Text(text = repo.description, modifier = Modifier.constrainAs(descriptionRf) {
            top.linkTo(fullNameRf.bottom)
        })

        Row(modifier = Modifier
            .constrainAs(infoRowRf) {
                top.linkTo(descriptionRf.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            .padding(top = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            InfoItem(
                icon = Icons.Outlined.Info, text = repo.language
            )
            InfoItem(
                text = "${repo.stargazersCount} Star"
            )
            InfoItem(
                icon = Icons.Default.Share, text = "${repo.watchersCount} Forked"
            )
        }
    }
}

@Preview
@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Star,
    contentDescription: String = "Description",
    text: String = "Java"
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = contentDescription)
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            modifier = Modifier.widthIn(0.dp, 80.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}