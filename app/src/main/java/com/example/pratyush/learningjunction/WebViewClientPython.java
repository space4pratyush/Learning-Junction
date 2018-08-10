package com.example.pratyush.learningjunction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebViewClientPython extends WebViewClient {
    private Activity activity = null;

    public WebViewClientPython(Activity activity) {
        this.activity = activity;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if(url.indexOf("https://thepythonguru.com/") > -1 ) {
            return false;
        }

        else {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }
    }
}