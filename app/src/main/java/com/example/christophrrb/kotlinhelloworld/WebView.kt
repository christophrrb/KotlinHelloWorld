package com.example.christophrrb.kotlinhelloworld

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView.webViewClient = WebViewClient();
        if (Build.VERSION.SDK_INT >= 19) {
            webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE;
            webView.loadUrl("http://phandroid.com");
            //"file:///android_asset/file_name.html (for local files in Android folder)
        } else {
            webView.loadUrl("http://phandroid.com");
        }
    }
}
