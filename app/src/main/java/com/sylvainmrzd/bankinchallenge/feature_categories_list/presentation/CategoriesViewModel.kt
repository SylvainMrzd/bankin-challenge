package com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sylvainmrzd.bankinchallenge.feature_categories_list.domain.model.Resource
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.sylvainmrzd.bankinchallenge.feature_categories_list.data.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class CategoriesViewModel@Inject constructor(): ViewModel() {

    var categoriesListResponse: List<Resource> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getCategoriesList(parentCategoryId: Int = -1) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val resourcesList = apiService.getResourcesItems().resources

                categoriesListResponse = resourcesList.filter {
                    if (parentCategoryId > -1) {
                        it.parent?.id == parentCategoryId
                    } else {
                        it.parent == null
                    }
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}