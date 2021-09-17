package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class International extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        WebView webView = findViewById(R.id.interNews);
        webView.loadUrl("https://www.bbc.com/news/world");
        webView.setWebViewClient(new WebViewController());
    }
}