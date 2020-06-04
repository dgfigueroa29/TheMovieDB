package com.example.boa.domain.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

class BaseStatusObserver<V, T>(
    private val observer: MediatorLiveData<V>,
    private val source: LiveData<BaseResource<T>>,
    private val successCallback: (d: T?) -> Unit,
    private val errorCallback: (e: BaseException?) -> Unit,
    private val progressCallback: ((p: Int) -> Unit)
) : Observer<BaseResource<T>> {
    init {
        observer.addSource(source, this)
    }

    override fun onChanged(t: BaseResource<T>?) {
        when (t?.resourceStatus) {
            BaseResourceStatus.LOADING -> {
                progressCallback(t.progress)
            }

            BaseResourceStatus.SUCCESS -> {
                successCallback(t.data)
                observer.removeSource(source)
            }

            BaseResourceStatus.ERROR -> {
                errorCallback(t.exception)
                observer.removeSource(source)
            }
        }
    }
}