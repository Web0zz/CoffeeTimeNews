package com.web0z.coffeetimenews.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.web0z.coffeetimenews.di.Repository
import com.web0z.coffeetimenews.ui.state.UiState
import com.web0z.core.model.Article
import com.web0z.core.repository.CoffeeTimeNewsRepository
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class ArticleDetailViewModel @AssistedInject constructor(
    @Repository private val coffeeTimeNewsRepository: CoffeeTimeNewsRepository,
    @Assisted private val articleId: String
): ViewModel() {
    private val _state = MutableStateFlow(UiState<Article>())

    val state: StateFlow<UiState<Article>>
        get() = _state

    init {
        getArticle()
    }

    private fun getArticle() {
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

    @AssistedFactory
    interface Factory {
        fun create(articleId: String): ArticleDetailViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            articleId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(articleId) as T
            }
        }
    }
}

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AssistedInjectModule
