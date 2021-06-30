package com.web0z.coffeetimenews.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.web0z.coffeetimenews.ui.state.UiState
import com.web0z.core.model.Article
import com.web0z.core.repository.CoffeeTimeNewsRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ArticleDetailViewModel constructor(
    private val articleId: String,
    private val coffeeTimeNewsRepository: CoffeeTimeNewsRepository
): ViewModel() {
    private val _state = MutableStateFlow(UiState<Article>())

    val state: StateFlow<UiState<Article>>
        get() = _state

    init {
        viewModelScope.launch {
            coffeeTimeNewsRepository.getArticleById(articleId)
                .onStart {
                    _state.value = UiState(loading = true, error = null, data = null)
                }
                .catch {
                    _state.value = UiState(loading = false, error = it.localizedMessage, data = null)
                }
                .collect { article ->
                    _state.value = UiState(loading = false, error = null, data = article)
                }
        }
    }
}
