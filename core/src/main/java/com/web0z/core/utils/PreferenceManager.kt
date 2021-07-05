package com.web0z.core.utils

import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface PreferenceManager {
    val uiModeFlow: Flow<Boolean>

    /**
     * Set preference for UI mode.
     *
     * @param enable Sets Dark Mode if true otherwise Light mode.
     */
    suspend fun setDarkMode(enable: Boolean)
}