package com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sylvainmrzd.bankinchallenge.feature_categories_list.domain.model.Resource
import com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation.components.CategoryItem

@Composable
fun CategoriesScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel(),
    categoryId: Int = -1
) {

    viewModel.getCategoriesList(categoryId)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val categoriesList: List<Resource> = viewModel.categoriesListResponse

           itemsIndexed(items = categoriesList) { index, item ->
                CategoryItem(category = item, index) { _ ->
                    navController.navigate(
                        Screen.SubCategoriesScreen.route +
                                "?categoryId=${item.id}"
                    )
                }
            }
        }
    }
}