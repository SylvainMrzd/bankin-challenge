package com.sylvainmrzd.bankinchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation.CategoriesScreen
import com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation.Screen
import com.sylvainmrzd.bankinchallenge.ui.theme.BankinChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankinChallengeTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ParentCategoriesScreen.route
                    ) {
                        composable(route = Screen.ParentCategoriesScreen.route) {
                            CategoriesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.SubCategoriesScreen.route +
                                    "?categoryId={categoryId}",
                            arguments = listOf(
                                navArgument(
                                    name = "categoryId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            val categoryId = it.arguments?.getInt("categoryId") ?: -1
                            CategoriesScreen(
                                navController = navController,
                                categoryId = categoryId
                            )
                        }
                    }
                }
            }
        }
    }
}