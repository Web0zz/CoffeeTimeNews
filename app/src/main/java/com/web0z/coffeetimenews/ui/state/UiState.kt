package com.web0z.coffeetimenews.ui.state

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