package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Belajar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            Intent m = new Intent(Belajar.this, Faraidh.class);
            startActivity(m);
        });
        findViewById(R.id.btn2).setOnClickListener(v -> {
            Intent c = new Intent(Belajar.this, ContohKasus.class);
            startActivity(c);

        });
        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());

    }
}