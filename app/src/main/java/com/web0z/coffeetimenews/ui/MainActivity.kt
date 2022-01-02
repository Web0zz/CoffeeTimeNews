package com.web0z.coffeetimenews.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.navigation.CoffeeTimeNavigation
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.view.article.ArticleDetailViewModel
import com.web0z.core.utils.PreferenceManager
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var preferenceManager: PreferenceManager

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface ViewModelFactoryProvider {
        fun articleDetailViewModelFactory(): ArticleDetailViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeTimeNewsMain()
        }
        observeUiTheme()
    }

    @Composable
    private fun CoffeeTimeNewsMain() {
        val darkMode by preferenceManager.uiModeFlow.collectAsState(initial = isSystemInDarkTheme())

        CoffeeTimeNewsTheme(darkTheme = darkMode) {
            Surface(color = MaterialTheme.colors.background) {
                CoffeeTimeNavigation()
            }
        }
    }

    private fun observeUiTheme() {
        lifecycleScope.launchWhenStarted {
            preferenceManager.uiModeFlow.collect { isDarkMode ->
                val mode = when (isDarkMode) {
                    true -> AppCompatDelegate.MODE_NIGHT_YES
                    false -> AppCompatDelegate.MODE_NIGHT_NO
                }
                AppCompatDelegate.setDefaultNightMode(mode)
            }
        }
    }
}
