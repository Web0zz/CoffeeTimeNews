package com.web0z.core.utils

import javax.inject.Singleton

@Singleton
interface PreferenceManager {

    /**
     * Set preference for UI mode.
     *
     * @param enable Sets Dark Mode if true otherwise Light mode.
     */
    suspend fun setDarkMode(enable: Boolean)
}