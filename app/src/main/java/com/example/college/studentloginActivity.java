package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.college.other.HomeActivity;

public class studentloginActivity extends AppCompatActivity {

    EditText student_username, student_password, student_repassword;
    Button student_btnsignIN;
    DBHelper student_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

        student_username = (EditText) findViewById(R.id.student_username);
        student_password = (EditText) findViewById(R.id.student_password);
        student_repassword = (EditText) findViewById(R.id.student_repassword);
        student_btnsignIN = (Button) findViewById(R.id.student_btnsignIN);

        student_DB = new DBHelper(this);

        student_btnsignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String student_user = student_username.getText().toString();
                String student_pass = student_password.getText().toString();
                String student_repass = student_repassword.getText().toString();

                if (student_user.equals("") || student_pass.equals("") || student_repass.equals("")) {
                    Toast.makeText(studentloginActivity.this, "Please all fields !", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (student_pass.equals(student_repass)) {
                        boolean checkStudentUserPass = student_DB.checkStudentUsernamePassword(student_user, student_pass);
                            if (checkStudentUserPass == true) {
                                Toast.makeText(studentloginActivity.this, "Sign In Successful !", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(studentloginActivity.this, easyActivity.class));
                            }
                            else {
                                Toast.makeText(studentloginActivity.this, "Invalid details !", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(studentloginActivity.this, "Password isn't matching !", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
}