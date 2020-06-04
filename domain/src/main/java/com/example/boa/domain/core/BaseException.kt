package com.example.boa.domain.core

import java.io.IOException

data class BaseException(val error: BaseError) : IOException()