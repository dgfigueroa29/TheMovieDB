package com.example.boa.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boa.data.core.BaseEntity

@Entity
data class TermEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var text: String = "",
    val isValid: Boolean = true,
    val resultCount: Int = 0
) : BaseEntity()