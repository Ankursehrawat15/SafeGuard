package com.example.android.safeguard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.safeguard.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    private FirebaseAuth auth;
    ProgressDialog progressbar;
    FirebaseDatabase database;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressbar = new ProgressDialog(this);
        progressbar.setMessage("Creating new account...");


        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname, username, email, phoneNo, password;
                fullname = binding.name.getEditText().getText().toString();
                username = binding.usernameUser.getEditText().getText().toString();
                email = binding.emailUser.getEditText().getText().toString();
                password = binding.passwordUser.getEditText().getText().toString();
                phoneNo = binding.phoneNoUser.getEditText().getText().toString();

                Users user = new Users(fullname, username, email, phoneNo, password);
                progressbar.show();
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String uid = task.getResult().getUser().getUid();
                            database.getReference("Users").child(uid).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                progressbar.dismiss();
                                                startActivity(new Intent(Register.this, Login.class));
                                                Toast.makeText(Register.this, "Registerd Successfully", Toast.LENGTH_SHORT).show();

                                            } else {
                                                Toast.makeText(Register.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    });
                        } else {
                            progressbar.dismiss();
                            Toast.makeText(Register.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

                binding.goToLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Register.this , Login.class));
                        finish();
                    }
                });


    }


}