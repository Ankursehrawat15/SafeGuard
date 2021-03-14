package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button callRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        callRegister = findViewById(R.id.callRegisterButton);

      callRegister.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(Login.this , Register.class);
              startActivity(intent);
          }
      });


    }
}