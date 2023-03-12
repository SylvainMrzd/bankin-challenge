package com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation

sealed class Screen(val route: String) {
    object ParentCategoriesScreen: Screen("categories_screen")
    object SubCategoriesScreen: Screen("sub_categories_screen")
}
