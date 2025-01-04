package com.demoapp.multiverse;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    WebView myWeb;
    ProgressBar pbLoader;
    WebViewClient myWebClient;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        myWeb = findViewById(R.id.my_web);
        pbLoader = findViewById(R.id.pb_loader);
        myWeb.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getStringExtra("url");

        myWebClient = new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                pbLoader.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                pbLoader.setVisibility(View.VISIBLE);
            }
        };
        myWeb.setWebViewClient(myWebClient);
        myWeb.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(myWeb.canGoBack()){
            myWeb.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
