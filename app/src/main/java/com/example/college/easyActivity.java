package com.example.college;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.college.other.HomeActivity;
import com.example.college.other.StudentItem;
import com.google.android.material.internal.ManufacturerUtils;

public class easyActivity extends AppCompatActivity {

    Toolbar toolcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        setMenu();
    }

    private void setMenu() {
        toolcar = findViewById(R.id.toolcaa);

        toolcar.inflateMenu(R.menu.other);
        toolcar.setOnMenuItemClickListener(menuItem -> onMenuItemClick(menuItem));
    }

    private boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.student_logout){
            startActivity(new Intent(easyActivity.this, MainActivity.class));
        }
        else if(menuItem.getItemId() == R.id.choke){
            startActivity(new Intent(easyActivity.this, ShowattendActivity.class));
        }
        return true;
    }




}