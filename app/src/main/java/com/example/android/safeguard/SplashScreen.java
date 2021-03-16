package com.example.android.safeguard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);  // status bar remove
        setContentView(R.layout.activity_splash_screen);

          // created Handler
        // declaring variable for time
        int splash_Screen = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             Intent intent = new Intent(SplashScreen.this , Home.class);
             startActivity(intent);
              finish();
            }
        }, splash_Screen);
    }





}