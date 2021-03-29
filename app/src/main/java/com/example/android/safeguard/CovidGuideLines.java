package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

public class CovidGuideLines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_guide_lines);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);




        WebView webView = findViewById(R.id.goToCovid);
        webView.loadUrl("https://www.mohfw.gov.in");
        webView.setWebViewClient(new WebViewController());
    }
}