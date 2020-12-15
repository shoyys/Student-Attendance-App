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

public class staffActivity extends AppCompatActivity {

    EditText staff_username, staff_password, staff_repassword;
    Button staff_btnsignUP;
    TextView staff_haveaccount;
    DBHelper staff_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        staff_username = (EditText) findViewById(R.id.staff_username);
        staff_password = (EditText) findViewById(R.id.staff_password);
        staff_repassword = (EditText) findViewById(R.id.staff_repassword);
        staff_btnsignUP = (Button) findViewById(R.id.staff_btnsignUP);
        staff_haveaccount = (TextView) findViewById(R.id.staff_haveAccount);

        staff_DB = new DBHelper(this);

        staff_btnsignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staff_user = staff_username.getText().toString();
                String staff_pass = staff_password.getText().toString();
                String staff_repass = staff_repassword.getText().toString();

                if(staff_user.equals("") || staff_pass.equals("") || staff_repass.equals("")){
                    Toast.makeText(staffActivity.this, "Please all fields !", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(staff_pass.equals(staff_repass)) {
                        boolean checkStaffUser = staff_DB.checkStaffUsername(staff_user);
                        if(checkStaffUser == false) {
                            boolean insertStaff = staff_DB.insertStaffData(staff_user, staff_pass);
                                if(insertStaff == true) {
                                     Toast.makeText(staffActivity.this, "Sign Up Successful !", Toast.LENGTH_SHORT).show();
                                     startActivity(new Intent(staffActivity.this, HomeActivity.class));
                                }
                                else {
                                    Toast.makeText(staffActivity.this, "Sign Up Unsuccessful !", Toast.LENGTH_SHORT).show();
                                }
                        }
                        else{
                            Toast.makeText(staffActivity.this, "User Already exists ! Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(staffActivity.this, "Password isn't matching !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        staff_haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(staffActivity.this, staffloginActivity.class));
            }
        });



    }

}