package com.web0z.coffeetimenews.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.web0z.coffeetimenews.di.Repository
import com.web0z.coffeetimenews.ui.state.UiState
import com.web0z.core.model.Article
import com.web0z.core.model.Category
import com.web0z.core.repository.CoffeeTimeNewsRepository
import com.web0z.core.repository.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Repository private val coffeeTimeNewsRepository: CoffeeTimeNewsRepository
): ViewModel() {

    private val selectedCategory = MutableStateFlow(Category.POPULAR)

    private val categories = MutableStateFlow(Category.values().asList())

    private val _state = MutableStateFlow(UiState<HomeViewData>())

    val state: StateFlow<UiState<HomeViewData>>
        get() = _state

    init {
        getArticles(Category.POPULAR)
    }

    fun getArticles(category: Category) {
        viewModelScope.launch {
            coffeeTimeNewsRepository.getArticleByCategory(category.category)
                .onStart {
                    _state.value =
                        UiState(
                            loading = true,
                            error = null,
                            data = HomeViewData(
                                categories.value,
                                selectedCategory.value,
                                emptyList()
                            )
                        )
                }
                .catch {
                    _state.value = UiState(
                        loading = false,
                        error = it.localizedMessage,
                        data = HomeViewData(
                            categories.value,
                            selectedCategory.value,
                            emptyList()
                        )
                    )
                }
                .collect {  result ->
                    when(result) {
                        is ResponseResult.Success -> _state.value =
                            UiState(
                                loading = false,
                                error = null,
                                data = HomeViewData(
                                    categories.value,
                                    selectedCategory.value,
                                    result.data
                                )
                            )
                        is ResponseResult.Error -> _state.value = UiState(
                            loading = false,
                            error = result.message,
                            data = HomeViewData(
                                categories.value,
                                selectedCategory.value,
                                emptyList()
                            )
                        )
                    }
                }
        }
    }

    fun onHomeCategorySelected(category: Category) {
        selectedCategory.value = category
    }
}

data class HomeViewData(
    val homeCategories: List<Category> = emptyList(),
    val selectedHomeCategory: Category = Category.POPULAR,
    val articlesList: List<Article> = emptyList()
)