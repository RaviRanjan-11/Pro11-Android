package live.pro11.app.game.navigation


sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login_screen")
    data object Register : Screen("register")
    data object OtpScreen : Screen("otp_screen")
    data object HomeTabBar : Screen("home_tab_bar")
}