package com.srizan.details.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.srizan.details.DetailsScreen


object DetailsScreenNavigation {
    private const val routeInitial = "details"
    const val userNameArg = "userNameArg"

    const val route = "$routeInitial/{$userNameArg}"

    fun getUserNameFromArgs(backStackEntry: NavBackStackEntry) =
        backStackEntry.arguments?.getString(userNameArg) ?: ""

    fun getNavigationRoute(userName: String) = "$routeInitial/$userName"
}
fun NavGraphBuilder.detailsScreen() {
    composable(DetailsScreenNavigation.route,
        arguments = listOf(
            navArgument(DetailsScreenNavigation.userNameArg){type = NavType.StringType}
        )
    ) {
        DetailsScreen(userName = DetailsScreenNavigation.getUserNameFromArgs(it) )
    }
}

fun NavController.navigateToDetailsScreen(userName: String, navOptions: NavOptions? = null) =
    navigate(DetailsScreenNavigation.getNavigationRoute(userName), navOptions)