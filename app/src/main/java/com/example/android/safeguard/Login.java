package com.example.android.safeguard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.safeguard.databinding.ActivityLoginBinding;
import com.example.android.safeguard.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {


    ActivityLoginBinding binding;  // binding id xml file
    ProgressDialog progressbar;  // progress bar
    FirebaseAuth auth;      // for authentication


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        auth = FirebaseAuth.getInstance();

        progressbar = new ProgressDialog(this);
        progressbar.setMessage("Logging in ...");




        binding.loginButtonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });
    }



    public void checkUser() {
        String email, password;
        email = binding.emailUser.getEditText().getText().toString();
        password = binding.passwordUser.getEditText().getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                progressbar.show();
                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressbar.dismiss();
                        Toast.makeText(Login.this, "Login Sucessfull !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, DashboardActivity.class));

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressbar.dismiss();
                        Toast.makeText(Login.this, "Login Failed !", Toast.LENGTH_SHORT).show();

                    }
                });
            } else {
                binding.passwordUser.setError("Empty Fields are not allowed");
            }
        } else if (email.isEmpty()) {
            binding.emailUser.setError("Empty Fields are not allowed");
        } else {
            binding.emailUser.setError("Please enter correct email");
        }






    }

    public void goToRegisteration(View view) {
        Intent intent = new Intent(Login.this , Register.class);
        startActivity(intent);
        finish();
    }
}










