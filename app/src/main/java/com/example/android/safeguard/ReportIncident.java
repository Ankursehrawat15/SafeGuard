package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import database.ReportDatabase;

public class ReportIncident extends AppCompatActivity {
    EditText name, phone_No, description, address, datereport;
    ReportDatabase myDb;
    Button submit, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_incident);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        myDb = new ReportDatabase(this);


        name = findViewById(R.id.userName);
        phone_No = findViewById(R.id.userContact);
        submit = findViewById(R.id.submitReport);
        view = findViewById(R.id.viewReport);
        description = findViewById(R.id.decriptionBox);
        address = findViewById(R.id.user_Address);
        datereport = findViewById(R.id.date);

        addData();


    }


    public void addData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(name.getText().toString(), phone_No.getText().toString(), address.getText().toString(), datereport.getText().toString(), description.getText().toString());
                if (isInserted) {
                    Toast.makeText(ReportIncident.this, "error", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReportIncident.this, "Successfully Submitted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}