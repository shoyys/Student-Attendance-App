package com.example.college;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "test.db";

    public DBHelper(Context context){
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create Table users (staff_username TEXT PRIMARY key, staff_password TEXT)");
        MyDB.execSQL("Create Table student(student_username TEXT PRIMARY Key, student_password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP Table if exists users");
        MyDB.execSQL("DROP Table if exists student");
    }

    public boolean insertStaffData(String staff_username, String staff_password){
        SQLiteDatabase staff_MyDB = this.getWritableDatabase();
        ContentValues staff_contentValues = new ContentValues();
        staff_contentValues.put("staff_username", staff_username);
        staff_contentValues.put("staff_password", staff_password);

        long staff_result = staff_MyDB.insert("users", null, staff_contentValues);

        if(staff_result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertStudentData(String student_username, String student_password){
        SQLiteDatabase student_MyDB = this.getWritableDatabase();
        ContentValues student_contentValues = new ContentValues();

        student_contentValues.put("student_username", student_username);
        student_contentValues.put("student_password", student_password);

        long student_result = student_MyDB.insert("student", null, student_contentValues);

        if(student_result == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean checkStaffUsername(String staff_username){
        SQLiteDatabase staff_MyDB = this.getWritableDatabase();
        Cursor staff_cursor = staff_MyDB.rawQuery("SELECT * from users where staff_username = ?", new String[] {staff_username});

        if(staff_cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkStudentUsername(String student_username){
        SQLiteDatabase student_MyDB = this.getWritableDatabase();
        Cursor student_cursor = student_MyDB.rawQuery("SELECT * from student where student_username = ?", new String[] {student_username});

        if(student_cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkStaffUsernamePassword(String staff_username, String staff_password){
        SQLiteDatabase staff_MyDB = this.getWritableDatabase();
        Cursor staff_cursor = staff_MyDB.rawQuery("SELECT * from users where staff_username = ? and staff_password = ?", new String[] {staff_username, staff_password});

        if(staff_cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkStudentUsernamePassword(String student_username, String student_password){
        SQLiteDatabase student_MyDB = this.getWritableDatabase();
        Cursor student_cursor = student_MyDB.rawQuery("SELECT * from student where student_username = ? and student_password = ?", new String[] {student_username, student_password});

        if(student_cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }



}
