package com.example.boa.themoviedb.core

/**
 * Base ViewStatus for using in Model-View-ViewModel architecture. Must contain all of the data necessary for the view to draw itself at the current state.
 */
open class BaseViewStatus {
    var isReady = false
    var isError = false
    var isComplete = false
    var isLoading = false
    var errorMessage: String = ""
}