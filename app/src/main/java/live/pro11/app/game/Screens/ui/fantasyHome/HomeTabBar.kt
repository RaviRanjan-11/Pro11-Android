package live.pro11.app.game.Screens.ui.fantasyHome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeTabBar(navController: NavController) {
    val selectedTab = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                contentColor = Color.Gray
            ) {
                BottomNavigationItem(
                    selected = selectedTab.value == 0,
                    onClick = {
                        selectedTab.value = 0
                        navController.navigate("home")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = if (selectedTab.value == 0) Color.Red else Color.Gray
                        )
                    },
                    label = { Text("Home", color = if (selectedTab.value == 0) Color.Red else Color.Gray) }
                )

                BottomNavigationItem(
                    selected = selectedTab.value == 1,
                    onClick = {
                        selectedTab.value = 1
                        navController.navigate("my_contest")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "My Contest",
                            tint = if (selectedTab.value == 1) Color.Red else Color.Gray
                        )
                    },
                    label = { Text("My Contest", color = if (selectedTab.value == 1) Color.Red else Color.Gray) }
                )

                BottomNavigationItem(
                    selected = selectedTab.value == 2,
                    onClick = {
                        selectedTab.value = 2
                        navController.navigate("reward")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Reward",
                            tint = if (selectedTab.value == 2) Color.Red else Color.Gray
                        )
                    },
                    label = { Text("Reward", color = if (selectedTab.value == 2) Color.Red else Color.Gray) }
                )

                BottomNavigationItem(
                    selected = selectedTab.value == 3,
                    onClick = {
                        selectedTab.value = 3
                        navController.navigate("portfolio")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Portfolio",
                            tint = if (selectedTab.value == 3) Color.Red else Color.Gray
                        )
                    },
                    label = { Text("Portfolio", color = if (selectedTab.value == 3) Color.Red else Color.Gray) }
                )

                BottomNavigationItem(
                    selected = selectedTab.value == 4,
                    onClick = {
                        selectedTab.value = 4
                        navController.navigate("profile")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = if (selectedTab.value == 4) Color.Red else Color.Gray
                        )
                    },
                    label = { Text("Profile", color = if (selectedTab.value == 4) Color.Red else Color.Gray) }
                )
            }
        }
    ) { innerPadding ->
        Column {
            Text("Home Tab Content", modifier = Modifier.padding(innerPadding))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ShowHomeTabBar() {
    val mockNavController = rememberNavController()
    HomeTabBar(mockNavController)
}