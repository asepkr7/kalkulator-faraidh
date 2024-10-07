package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class ContohKasus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_kasus);

        TextView con1 =  findViewById(R.id.textViewContoh1);
        TextView con2 =  findViewById(R.id.textViewContoh2);
        TextView con3 =  findViewById(R.id.textViewContoh3);
        TextView con4 =  findViewById(R.id.textViewContoh4);
        TextView con5 =  findViewById(R.id.textViewContoh5);
        con1.setText("Ahli Waris : Suami dan 2 Saudari Kandung\nHarta : 70 jt\n\nJAWABAN\nSuami = 1/6 x 6 = 3\n2 Saudari Kandung = 2/3 x 6 = 4\nJumlah Bagian = 3 + 4 = 7 (Aul)\n\nHASIL\nSuami = 3/7 x 70jt = 30jt\n2 Saudari Kandung = 4/7 x 70jt = 40jt");
        con2.setText("Ahli Waris : Istri, 2 Saudara Seibu dan Ibu\nHarta : 9 jt\n\nJAWABAN\nIstri = 1/4 x 12 = 3\n2 Saudara Seibu = 1/3 x 12 = 4\nIbu = 1/6 x 12 = 2\nJumlah Bagian = 3 + 4 + 2 = 9 (Radd)\n\nHASIL\nIstri = 1/4 x 9jt = 2.25jt\n2 Saudara Seibu = 4/6 x 6.75jt = 4.5jt\nIbu = 2/6 x 6.75jt = 2.25jt");
        con3.setText("Ahli Waris : Suami, Ibu dan Bapak\nHarta : 60 jt\n\nJAWABAN\nSuami = 1/2 x 60jt = 30jt\nSisa = 60jt - 30jt = 30jt (Gharawain)\n\nHASIL\nSuami = 30jt\nIbu = 1/3 x 30jt = 10jt\nBapak = 30jt - 10jt = 20jt");
        con4.setText("Ahli Waris : Suami, Ibu, 2 Saudara Seibu, dan Saudara Kandung Laki-laki\nHarta : 60 jt\n\nJAWABAN\nSuami = 1/2 x 6 = 3\nIbu = 1/6 x 6 = 1\n2 Saudara Seibu = 1/3 x 6 = 2\nSaudara Kandung Laki-laki = 0\n(Musyarakah)\n\nHASIL\nSuami = 3/6 x 60jt = 30jt\nIbu = 1/6 x 60jt = 10jt\n2 Saudara Seibu + Saudara Kandung Laki-laki = 2/6 x 60jt = 20jt");
        con5.setText("Ahli Waris : Ibu, Istri, 2 Anak Laki-laki\nHarta : 96 jt\n\nJAWABAN\nIbu = 1/6 x 24 = 4\nIstri = 1/8 x 24 = 3\n2 Anak Laki-laki = 24 - 4 - 3 = 17\n\nHASIL\nIbu = 4/24 x 96jt = 16jt\nIstri = 3/24 x 96jt = 12jt\n2 Anak Laki-laki = 17/24 x 96jt = 68jt");

        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());

    }
    }
