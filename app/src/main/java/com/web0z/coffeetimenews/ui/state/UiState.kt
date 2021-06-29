package com.web0z.coffeetimenews.ui.state

import com.web0z.core.repository.ResponseResult

/**
 * Immutable data class that allows for loading, data, and exception to be managed independently.
 *
 * This is useful for screens that want to show the last successful result while loading or a later
 * refresh has caused an error.
 *
 * Referenced from Android compose-samples repository
 *
 * https://github.com/android/compose-samples
 */
data class UiState<T>(
    val loading: Boolean = false,
    val error: String? = null,
    val data: T? = null
) {
    /**
     * True if this contains an error
     */
    val hasError: Boolean
        get() = error != null

    /**
     * True if this represents a first load
     */
    val initialLoad: Boolean
        get() = data == null && loading && !hasError
}