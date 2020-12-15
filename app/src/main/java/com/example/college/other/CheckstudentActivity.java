package com.example.college.other;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.college.R;

public class CheckstudentActivity extends AppCompatActivity {

    EditText phone;
    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkstudent);

        phone = (EditText) findViewById(R.id.phoneno);
        check = (Button) findViewById(R.id.checker);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CheckstudentActivity.this, HomeActivity.class));

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                    if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        sendSMS();
                    }
                    else {
                        requestPermissions(new String[] {Manifest.permission.SEND_SMS}, 1);
                    }
                }
            }
        });
    }

    private void sendSMS(){

        String ph = phone.getText().toString();

        try {
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(ph, null, "Total Students-5, Present-4, Absent-1", null, null);
            Toast.makeText(CheckstudentActivity.this, "Message Sent !", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(CheckstudentActivity.this, "Message not Sent !", Toast.LENGTH_SHORT).show();
        }


    }
}