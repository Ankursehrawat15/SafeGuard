package com.example.android.safeguard;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.example.android.safeguard.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    public void goToMaps(View view) {
        Intent intent = new Intent(DashboardActivity.this , Maps.class);
        startActivity(intent);
    }

    public void reportIncident(View view) {
        startActivity(new Intent(DashboardActivity.this , ReportIncident.class));
    }
}