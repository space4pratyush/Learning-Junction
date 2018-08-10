package com.example.pratyush.learningjunction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebViewClientJs extends WebViewClient {
    private Activity activity = null;

    public WebViewClientJs(Activity activity) {
        this.activity = activity;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if(url.indexOf("https://learnjavascript.today/") > -1 ) {
            return false;
        }

        else {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }
    }
}