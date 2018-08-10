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

public class HtmlFragment extends Fragment {
    WebView webView=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_java,container,false);
        WebView webView=view.findViewById(R.id.web);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewClientPython webViewClientPython=new WebViewClientPython(getActivity());
        webView.setWebViewClient(webViewClientPython);

        webView.loadUrl("https://html.com/");
        return view;
    }
}
