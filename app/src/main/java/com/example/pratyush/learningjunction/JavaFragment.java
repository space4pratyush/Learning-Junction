package com.example.pratyush.learningjunction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class JavaFragment extends Fragment {
    private WebView webView = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_java,container,false);
        WebView webView=v.findViewById(R.id.web);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewClientJava webViewClientJava=new WebViewClientJava(getActivity());
        webView.setWebViewClient(webViewClientJava);

        webView.loadUrl("https://javabeginnerstutorial.com/core-java-tutorial/");

        return v;
    }
}
