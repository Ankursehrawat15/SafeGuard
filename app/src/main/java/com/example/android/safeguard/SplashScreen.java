package com.example.android.safeguard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int Splash_Screen = 2000;   // declaring variable for time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

          // created Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             Intent intent = new Intent(SplashScreen.this , Login.class);
             startActivity(intent);
              finish();
            }
        }, Splash_Screen);
    }





}