package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

public class IndiaTv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_tv);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        WebView webView = findViewById(R.id.loadIndiaTv);
        webView.loadUrl("https://www.indiatoday.in/crime");
        webView.setWebViewClient(new WebViewController());
    }
}