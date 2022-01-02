package com.web0z.coffeetimenews.ui.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.web0z.coffeetimenews.di.Repository
import com.web0z.coffeetimenews.ui.state.UiState
import com.web0z.core.model.Article
import com.web0z.core.model.Category
import com.web0z.core.repository.CoffeeTimeNewsRepository
import com.web0z.core.repository.ResponseResult
import com.web0z.core.utils.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Repository private val coffeeTimeNewsRepository: CoffeeTimeNewsRepository,
    private val preferenceManager: PreferenceManager
) : ViewModel() {

    private val selectedCategory = MutableStateFlow(Category.POPULAR)

    private val _state = MutableStateFlow(UiState<NewsListViewData>())
    val state: StateFlow<UiState<NewsListViewData>>
        get() = _state

    private val _pagerNews = MutableStateFlow(UiState<List<Article>>())
    val pagerNews: StateFlow<UiState<List<Article>>>
        get() = _pagerNews

    init {
        getArticles(Category.POPULAR)
    }

    private fun getArticles(category: Category) {
        viewModelScope.launch {
            coffeeTimeNewsRepository.getArticleByCategory(category.category)
                .onStart {
                    _state.value =
                        UiState(
                            loading = true,
                            error = null,
                            data = NewsListViewData(
                                selectedCategory.value,
                                emptyList()
                            )
                        )
                }
                .catch {
                    _state.value = UiState(
                        loading = false,
                        error = it.localizedMessage,
                        data = NewsListViewData(
                            selectedCategory.value,
                            emptyList()
                        )
                    )
                }
                .collect { result ->
                    when (result) {
                        is ResponseResult.Success -> {
                            _state.value =
                                UiState(
                                    loading = false,
                                    error = null,
                                    data = NewsListViewData(
                                        selectedCategory.value,
                                        result.data
                                    )
                                )
                            if (_pagerNews.value.data.isNullOrEmpty()) {
                                _pagerNews.value =
                                    UiState(
                                        loading = false,
                                        error = null,
                                        data = result.data
                                    )
                            }
                        }
                        is ResponseResult.Error -> _state.value = UiState(
                            loading = false,
                            error = result.message,
                            data = NewsListViewData(
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
        getArticles(category)
    }

    fun setDarkMode(enable: Boolean) {
        viewModelScope.launch {
            preferenceManager.setDarkMode(enable)
        }
    }
}

data class NewsListViewData(
    val selectedHomeCategory: Category = Category.POPULAR,
    val articlesList: List<Article> = emptyList()
)