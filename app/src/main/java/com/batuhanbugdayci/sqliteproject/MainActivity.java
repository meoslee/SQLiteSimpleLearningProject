package com.batuhanbugdayci.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Musician", MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,NAME VARCHAR,AGE INTEGER)" );
            //database.execSQL("INSERT INTO musicians (NAME,AGE) VALUES ('James',50) ");
            //database.execSQL("INSERT INTO musicians (NAME,AGE) VALUES ('Lars',60) ");
            //database.execSQL("INSERT INTO musicians (NAME,AGE) VALUES ('Kirk',55) ");

            //database.execSQL("UPDATE musicians SET name = 'Kirk Hammet' WHERE id = 3");

            //database.execSQL("DELETE FROM musicians WHERE id = 2");

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'James' ",null);
            Cursor cursor = database.rawQuery("SELECT * FROM musicians ",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'K%'",null);


            int nameIx = cursor.getColumnIndex("NAME");
            int ageIX = cursor.getColumnIndex("AGE");
            int idIX = cursor.getColumnIndex("id");


            while (cursor.moveToNext()){
                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIX));
                System.out.println("ID: " + cursor.getInt(idIX));


            }
            cursor.close();


        }catch (Exception e){
            e.printStackTrace();

        }



    }
}