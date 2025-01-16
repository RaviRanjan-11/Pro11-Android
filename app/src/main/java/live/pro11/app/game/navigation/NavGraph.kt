package live.pro11.app.game.navigation

import live.pro11.app.game.Screens.ui.onboarding.Splash.SplashScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import live.pro11.app.game.Screens.ui.onboarding.login.LoginScreen
import live.pro11.app.game.Screens.ui.onboarding.otp.OTPScreen
import live.pro11.app.game.Screens.ui.onboarding.Register.RegisterScreen
import live.pro11.app.game.Screens.ui.fantasyHome.HomeTabBar


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Register.route) {
           RegisterScreen(navController)

        }
        composable(
            route = "otp_screen/{email}/{token}",
            arguments = listOf(
                navArgument("email") { type = NavType.StringType },
                navArgument("token") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""

            val token = backStackEntry.arguments?.getString("token") ?: ""

            // Fixed with named arguments
            OTPScreen(navController = navController, token = token, email = email)
        }

        composable(Screen.HomeTabBar.route) {
            HomeTabBar(navController)
        }
    }
}








