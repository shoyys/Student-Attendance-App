package com.example.college;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void staff(View view){
        Intent staff = new Intent(this, staffActivity.class);
        startActivity(staff);
    }

    public void student(View view){
        Intent student = new Intent(this, studentActivity.class);
        startActivity(student);
    }

}