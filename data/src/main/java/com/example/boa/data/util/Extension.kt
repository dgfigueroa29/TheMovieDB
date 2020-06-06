package com.example.boa.data.util

import com.example.boa.data.datasource.remote.response.ItemResponse

fun List<ItemResponse>?.toStringLabel(): String {
    var label = ""

    if (!this.isNullOrEmpty()) {
        this.forEach {
            label += "${it.name}, "
        }
    }

    return label
}