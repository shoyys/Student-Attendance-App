package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.college.other.HomeActivity;

public class studentActivity extends AppCompatActivity {

    EditText student_username, student_password, student_repassword;
    Button student_btnsignUP;
    TextView student_haveaccount;
    DBHelper student_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        student_username = (EditText) findViewById(R.id.student_username);
        student_password = (EditText) findViewById(R.id.student_password);
        student_repassword = (EditText) findViewById(R.id.student_repassword);
        student_btnsignUP = (Button) findViewById(R.id.student_btnsignUP);
        student_haveaccount = (TextView) findViewById(R.id.student_haveAccount);
        student_DB = new DBHelper(this);

        student_btnsignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String student_user = student_username.getText().toString();
                String student_pass = student_password.getText().toString();
                String student_repass = student_repassword.getText().toString();

                if (student_user.equals("") || student_pass.equals("") || student_repass.equals("")) {
                    Toast.makeText(studentActivity.this, "Please all fields !", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (student_pass.equals(student_repass)) {
                        boolean checkStudentUser = student_DB.checkStudentUsername(student_user);
                        if (checkStudentUser == false) {
                            boolean insertStudent = student_DB.insertStudentData(student_user, student_pass);
                                if (insertStudent == true) {
                                    Toast.makeText(studentActivity.this, "Sign Up Successful !", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(studentActivity.this, easyActivity.class));
                                }
                                else {
                                    Toast.makeText(studentActivity.this, "Sign Up Unsuccessful !", Toast.LENGTH_SHORT).show();
                                }
                        }
                        else {
                            Toast.makeText(studentActivity.this, "User Already exists ! Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(studentActivity.this, "Password isn't matching !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        student_haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(studentActivity.this, studentloginActivity.class));
            }
        });

    }
}