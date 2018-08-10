package com.example.pratyush.learningjunction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientJava extends WebViewClient {
    private Activity activity=null;

    public WebViewClientJava(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if(url.indexOf("https://javabeginnerstutorial.com/core-java-tutorial/") > -1 ) {
            return false;
        }

        else {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }
    }
}