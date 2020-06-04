package com.example.boa.data.mapper

import com.example.boa.data.entity.TermEntity
import com.example.boa.domain.core.BaseMapper

class TermEntityToString : BaseMapper<TermEntity, String>() {
    override fun map(input: TermEntity): String = input.text
}