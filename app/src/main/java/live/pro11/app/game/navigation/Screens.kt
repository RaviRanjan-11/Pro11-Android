package live.pro11.app.game.navigation


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login_screen")
    object Register : Screen("register")
    object OtpScreen : Screen("otp_screen")
    object HomeTabBar : Screen("home_tab_bar")
}