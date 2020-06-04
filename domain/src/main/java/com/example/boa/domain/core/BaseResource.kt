package com.example.boa.domain.core

data class BaseResource<out T>(
    val resourceStatus: BaseResourceStatus,
    val data: T? = null,
    val exception: BaseException? = null,
    val progress: Int = 0
) {
    companion object {
        fun <T> success(data: T?): BaseResource<T> {
            return BaseResource(BaseResourceStatus.SUCCESS, data)
        }

        fun <T> error(exception: BaseException?): BaseResource<T> {
            return BaseResource(BaseResourceStatus.ERROR, exception = exception)
        }

        fun <T> loading(progress: Int): BaseResource<T> {
            return BaseResource(BaseResourceStatus.LOADING, progress = progress)
        }
    }
}