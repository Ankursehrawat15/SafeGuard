package com.example.android.safeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CloseGroup extends AppCompatActivity {
    private EditText mobileNo, message;
    Button sendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_group);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mobileNo = findViewById(R.id.emergencyNo1);
        sendSms = findViewById(R.id.button);
        message = findViewById(R.id.messageE);

        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = mobileNo.getText().toString();
                String msg = message.getText().toString();

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", new String(no));
                smsIntent.putExtra("sms_body", msg);
                startActivity(smsIntent);
            }
        });


    }


//
//


//    //Get the SmsManager instance and call the sendTextMessage method to send message
//    SmsManager sms=SmsManager.getDefault();
//sms.sendTextMessage("8802177690", null, "hello javatpoint", pi,null);


}