package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.android.safeguard.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {

    Button user , admin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        user = findViewById(R.id.goToUser);
        admin = findViewById(R.id.goToAdmin);

    }

    public void goToUser(View view) {
        startActivity(new Intent(Home.this , Login.class));
    }

    public void goToAdmin(View view) {
    }
}