package com.example.boa.themoviedb.util

import android.content.Context
import android.os.Handler
import android.view.Gravity
import android.webkit.WebSettings
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView?.build(context: Context) {
    val layoutManager = LinearLayoutManager(context)
    layoutManager.orientation = LinearLayoutManager.VERTICAL
    this?.hasFixedSize()
    this?.layoutManager = layoutManager
    this?.addItemDecoration(
        DividerItemDecoration(
            context,
            layoutManager.orientation
        )
    )
    this?.itemAnimator = object : DefaultItemAnimator() {
        override fun animateAdd(holder: RecyclerView.ViewHolder?): Boolean {
            dispatchAddFinished(holder)
            dispatchAddStarting(holder)
            return false
        }
    }
}

fun Context.toast(message: String) {
    Handler().post {
        val toast: Toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}

@Suppress("SetJavaScriptEnabled", "DEPRECATION")
fun WebSettings?.build() {
    this?.javaScriptEnabled = true
    this?.mediaPlaybackRequiresUserGesture = false
    this?.setRenderPriority(WebSettings.RenderPriority.HIGH)
    this?.loadWithOverviewMode = true
    this?.useWideViewPort = true
    this?.setSupportZoom(false)
    this?.builtInZoomControls = false
    this?.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
    this?.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
}