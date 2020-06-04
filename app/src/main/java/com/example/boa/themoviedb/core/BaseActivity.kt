@file:Suppress("DEPRECATION")

package com.example.boa.themoviedb.core

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

abstract class BaseActivity<VS, VM : BaseViewModel<VS>> : AppCompatActivity() {
    lateinit var viewModel: VM
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
        viewModel.resourceViewState.observe(this, viewStatusObserver)
        setContentView(getLayoutResource())
    }

    private val viewStatusObserver = Observer<VS> {
        onViewStatusUpdated(it)
    }

    fun showLoading() {
        hideLoading()
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("Cargando...")
        progressDialog?.show()
    }

    fun hideLoading() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
            progressDialog = null
        }
    }

    abstract fun initViewModel(): VM
    abstract fun getLayoutResource(): Int
    abstract fun onViewStatusUpdated(viewStatus: VS)
}