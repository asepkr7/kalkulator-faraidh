package com.example.myfaraid;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");


         findViewById(R.id.tombol1).setOnClickListener(v -> {
             Intent i = new Intent(MainActivity.this, ListPewaris.class);
             startActivity(i);

         });
         findViewById(R.id.tombol2).setOnClickListener(v -> {
             Intent f = new Intent(MainActivity.this, Belajar.class);
             startActivity(f);

         });
         findViewById(R.id.tombol3).setOnClickListener(v -> {
             Intent a = new Intent(MainActivity.this, About.class);
             startActivity(a);

         });
         findViewById(R.id.tombol4).setOnClickListener(v -> {
             Intent c = new Intent(MainActivity.this, Bantuan.class);
             startActivity(c);

         });


    }


}