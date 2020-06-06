package com.example.boa.domain.util

import java.util.*

fun String?.hasValue(): Boolean = if (this != null) {
    this.toLowerCase(Locale.getDefault()).trim() != "null" && this.toLowerCase(Locale.getDefault())
        .trim().isNotEmpty()
} else {
    false
}

fun String?.parseAverage(): String {
    val parsed = if (this.hasValue()) {
        this?.replace(".", "") ?: "0"
    } else {
        "0"
    }

    return if (parsed.length == 1 && parsed != "0") {
        "${parsed}0%"
    } else {
        "$parsed%"
    }
}