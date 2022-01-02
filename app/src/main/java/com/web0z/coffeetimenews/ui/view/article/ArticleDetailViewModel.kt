package com.web0z.coffeetimenews.ui.view.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.web0z.coffeetimenews.di.Repository
import com.web0z.coffeetimenews.ui.state.UiState
import com.web0z.core.model.Article
import com.web0z.core.repository.CoffeeTimeNewsRepository
import com.web0z.core.repository.ResponseResult
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ArticleDetailViewModel @AssistedInject constructor(
    @Repository private val coffeeTimeNewsRepository: CoffeeTimeNewsRepository,
    @Assisted private val articleId: String
) : ViewModel() {
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
                    /**
                     * If catch any error while getting data from database
                     * it will try to take data from api by id
                     */
                    coffeeTimeNewsRepository.getArticleByIdFromApi(articleId)
                        .onStart {
                            _state.value = UiState(loading = true, error = null, data = null)
                        }
                        .catch {
                            _state.value =
                                UiState(loading = false, error = it.localizedMessage, data = null)
                        }
                        .collect { articleResponse ->
                            when (articleResponse) {
                                is ResponseResult.Success -> {
                                    _state.value = UiState(
                                        loading = false,
                                        error = null,
                                        data = articleResponse.data
                                    )
                                }
                                is ResponseResult.Error -> {
                                    _state.value = UiState(
                                        loading = false,
                                        error = articleResponse.message,
                                        data = null
                                    )
                                }
                            }
                        }
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
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(articleId) as T
            }
        }
    }
}

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AssistedInjectModule
