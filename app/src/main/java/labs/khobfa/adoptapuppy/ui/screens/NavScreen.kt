package labs.khobfa.adoptapuppy.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController


sealed class MainScreens(
    val route: String,
) {
    object DashBoard : MainScreens("home")
    object Details : MainScreens("details")
}


@ExperimentalFoundationApi
@Composable
fun NavScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreens.DashBoard.route
    ) {
        composable(MainScreens.DashBoard.route) {
            PuppyListScreen(navController)
        }

        composable(
            "${MainScreens.Details.route}/{position}",
            arguments = listOf(navArgument("position") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("position")?.let {
                PuppyDetailScreen(
                    navController,
                    it
                )
            }
        }
    }
}