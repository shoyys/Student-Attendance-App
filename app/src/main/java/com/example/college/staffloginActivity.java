package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.college.other.HomeActivity;

public class staffloginActivity extends AppCompatActivity {

    EditText staff_username, staff_password, staff_repassword;
    Button staff_btnsignIN;
    DBHelper staff_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        staff_username = (EditText) findViewById(R.id.staff_username);
        staff_password = (EditText) findViewById(R.id.staff_password);
        staff_repassword = (EditText) findViewById(R.id.staff_repassword);
        staff_btnsignIN = (Button) findViewById(R.id.staff_btnsignIN);

        staff_DB = new DBHelper(this);

        staff_btnsignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staff_user = staff_username.getText().toString();
                String staff_pass = staff_password.getText().toString();
                String staff_repass = staff_repassword.getText().toString();

                if (staff_user.equals("") || staff_pass.equals("") || staff_repass.equals("")) {
                    Toast.makeText(staffloginActivity.this, "Please all fields !", Toast.LENGTH_SHORT).show();
                }
                else {
                        if (staff_pass.equals(staff_repass)) {
                            boolean checkStaffUserPass = staff_DB.checkStaffUsernamePassword(staff_user, staff_pass);
                                if (checkStaffUserPass == true) {
                                    Toast.makeText(staffloginActivity.this, "Sign In Successful !", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(staffloginActivity.this, HomeActivity.class));
                                }
                                else {
                                    Toast.makeText(staffloginActivity.this, "Invalid details !", Toast.LENGTH_SHORT).show();
                                }
                        }
                        else {
                            Toast.makeText(staffloginActivity.this, "Password isn't matching !", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
}
