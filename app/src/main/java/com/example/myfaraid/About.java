package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tentang = (TextView) findViewById(R.id.textViewAbout);
        tentang.setText("Aplikasi Kalkulator Faroidh dibuat untuk mempelajari tentang Ilmu Faroidh dan menghitung secara otomatis pembagian harta warisan dalam Islam. ");

        ImageButton btnback = findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());
    }
}