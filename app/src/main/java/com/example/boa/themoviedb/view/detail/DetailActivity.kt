package com.example.boa.themoviedb.view.detail

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View.OnKeyListener
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.boa.themoviedb.R
import com.example.boa.themoviedb.core.BaseActivity
import com.example.boa.themoviedb.util.COLLECTION_PREVIEW_KEY
import com.example.boa.themoviedb.util.PREVIEW_KEY
import com.example.boa.themoviedb.util.build
import com.example.boa.themoviedb.util.toast
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.io.File

class DetailActivity : BaseActivity<DetailViewStatus, DetailViewModel>() {
    private var previewUrl = ""
    private var collectionUrl = ""
    private var isPlaying = false

    override fun initViewModel(): DetailViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.activity_detail

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLoading()
        activityWebView.settings.build()
        activityWebView.webViewClient = MyWebClient()
        collectionUrl = intent.getStringExtra(COLLECTION_PREVIEW_KEY) ?: ""
        previewUrl = intent.getStringExtra(PREVIEW_KEY) ?: intent.getStringExtra(PREVIEW_KEY) ?: ""
        activityWebView.setOnKeyListener(OnKeyListener { _, keyCode, event ->
            try {
                if (event.action != KeyEvent.ACTION_DOWN) {
                    return@OnKeyListener true
                }

                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    onBackPressed()
                    return@OnKeyListener true
                }
            } catch (e: Exception) {
            }
            false
        })
        activityWebView.setOnTouchListener { _, _ ->
            if (!isPlaying) {
                showLoading()
                isPlaying = true
                viewModel.load(previewUrl)
            }

            false
        }

        viewModel.load(collectionUrl)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val permissionsList: MutableList<String> = ArrayList()
            for (permission in arrayOf(Manifest.permission.INTERNET)) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                        permissionsList.add(permission)
                    }
                }
            }

            if (permissionsList.isNotEmpty()) {
                val callBack = 0
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.INTERNET),
                    callBack
                )
            }
        }
    }

    override fun onViewStatusUpdated(viewStatus: DetailViewStatus) {
        if (viewStatus.url.isNotEmpty()) {
            activityWebView.loadUrl(viewStatus.url)
        }
    }

    override fun onBackPressed() {
        if (isPlaying) {
            activityWebView.loadUrl(collectionUrl)
            isPlaying = false
        } else {
            this@DetailActivity.finish()
        }
    }

    private inner class MyWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            hideLoading()
            super.onPageFinished(view, url)
        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            view.apply {
                File(this@DetailActivity.cacheDir, "org.chromium.android_webview").let {
                    if (error?.errorCode == -2 && (!it.exists() || it.listFiles()?.size ?: 0 < 5)) {
                        this@DetailActivity.toast("No tienes conexión a internet")
                    }
                }
            }

            super.onReceivedError(view, request, error)
        }
    }

    @Suppress("DEPRECATION")
    override fun onDestroy() {
        super.onDestroy()
        activityWebView.clearHistory()
        activityWebView.clearView()
        activityWebView.removeAllViews()
        activityWebView.destroy()
    }
}