package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Guidelines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void gotToCovidGuide(View view) {
        startActivity(new Intent(Guidelines.this, CovidGuideLines.class));
    }


    public void gotToGuide(View view) {
        startActivity(new Intent(Guidelines.this, indiaGuidelines.class));
    }
}