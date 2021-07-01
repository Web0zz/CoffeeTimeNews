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
    private val _state = MutableStateFlow(UiState<HashMap<Category, List<Article>>>())

    val state: StateFlow<UiState<HashMap<Category, List<Article>>>>
        get() = _state

    init {
        getArticles(Category.POPULAR)
    }

    fun getArticles(category: Category) {
        viewModelScope.launch {
            coffeeTimeNewsRepository.getArticleByCategory(category.name)
                .onStart {
                    _state.value = UiState(loading = true, error = null, data = null)
                }
                .catch {
                    _state.value = UiState(loading = false, error = it.localizedMessage, data = null)
                }
                .collect {  result ->
                    when(result) {
                        is ResponseResult.Success -> _state.value = UiState(loading = false, error = null, data = hashMapOf(Pair(category, result.data)))
                        is ResponseResult.Error -> _state.value = UiState(loading = false, error = "Couldn't find any data", data = null)
                    }
                }
        }
    }
}