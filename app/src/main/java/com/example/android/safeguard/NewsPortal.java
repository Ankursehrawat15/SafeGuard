package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

public class NewsPortal extends AppCompatActivity {

    Button indiaTv , international;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_portal);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        indiaTv = findViewById(R.id.indiaTvPortal);
        international = findViewById(R.id.interNews);

        international.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsPortal.this , International.class));
            }
        });


        indiaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsPortal.this , IndiaTv.class));
            }
        });


    }
}