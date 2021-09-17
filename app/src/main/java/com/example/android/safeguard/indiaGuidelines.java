package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class indiaGuidelines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_guidelines);


        WebView webView = findViewById(R.id.goToguidelines);
        webView.loadUrl("https://www.india.gov.in/my-government/documents/guidelines");
        webView.setWebViewClient(new WebViewController());
    }
}