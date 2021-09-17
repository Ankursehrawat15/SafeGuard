package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CheckStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_status);

        String name = getIntent().getStringExtra("name");
        String contact = getIntent().getStringExtra("contact");
    }
}