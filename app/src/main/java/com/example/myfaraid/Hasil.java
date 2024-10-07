package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    int AnakLakilaki = 0, AnakPerempuan = 0;
    int Suami = 0, Istri = 0;
    int Ayah = 0, Ibu = 0;
    int Kakek = 0, Nenek = 0;
    int SaudaraKandung = 0, SaudariKandung = 0;
    int Bagian = 0, sisa = 0;
    protected Cursor cursor;
    public static ListPewaris lp;
    DataSql dbSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        Intent intent = getIntent();

        Button simpan = findViewById(R.id.simpan);

        dbSql = new DataSql(this);

        //menerima nilai harta dari ahli waris
        final String jumlahHarta = intent.getStringExtra("harta");
        final String Hutang = intent.getStringExtra("utang");
        final String PengurusanJenazah = intent.getStringExtra("urus");
        final String Wasiat = intent.getStringExtra("wasiat");
        final String Nama = intent.getStringExtra("nama");
        final String JK = intent.getStringExtra("jk");

        //menerima nilai ahli waris
        final String sAnakLakilaki = intent.getStringExtra("AnakLakilaki");
        final String sAnakPerempuan = intent.getStringExtra("AnakPerempuan");

        final String sSuami = intent.getStringExtra("Suami");
        final String sIstri = intent.getStringExtra("Istri");

        final String sAyah = intent.getStringExtra("Ayah");
        final String sIbu = intent.getStringExtra("Ibu");

        final String sKakek = intent.getStringExtra("Kakek");
        final String sNenek = intent.getStringExtra("Nenek");

        final String sSaudaraKandung = intent.getStringExtra("SaudaraKandung");
        final String sSaudariKandung = intent.getStringExtra("SaudariKandung");


        //default jika data ahli waris bernilai 0, maka tidak ditampilkan
        //awal state
        if (sAnakLakilaki.equals("0")) {
            LinearLayout GAnakLakilaki =  findViewById(R.id.GAnakLakilaki);
            GAnakLakilaki.setVisibility(View.GONE);
        }
        else {
            AnakLakilaki = Integer.parseInt(sAnakLakilaki);
        }

        if (sAnakPerempuan.equals("0")) {
            LinearLayout GAnakPerempuan =  findViewById(R.id.GAnakPerempuan);
            GAnakPerempuan.setVisibility(View.GONE);
        }
        else {
            AnakPerempuan = Integer.parseInt(sAnakPerempuan);
        }

        if (sSuami.equals("0")) {
            LinearLayout GSuami =  findViewById(R.id.GSuami);
            GSuami.setVisibility(View.GONE);
        }
        else {
            Suami = Integer.parseInt(sSuami);
        }

        if (sIstri.equals("0")) {
            LinearLayout GIstri =  findViewById(R.id.GIstri);
            GIstri.setVisibility(View.GONE);
        }
        else {
            Istri = Integer.parseInt(sIstri);
        }

        if (sAyah.equals("0")) {
            LinearLayout GAyah =  findViewById(R.id.GAyah);
            GAyah.setVisibility(View.GONE);
        }
        else {
            Ayah = Integer.parseInt(sAyah);
        }

        if (sIbu.equals("0")) {
            LinearLayout GIbu =  findViewById(R.id.GIbu);
            GIbu.setVisibility(View.GONE);
        }
        else {
            Ibu = Integer.parseInt(sIbu);
        }

        if (sKakek.equals("0")) {
            LinearLayout GKakek =  findViewById(R.id.GKakek);
            GKakek.setVisibility(View.GONE);
        }
        else {
            Kakek = Integer.parseInt(sKakek);
        }

        if (sNenek.equals("0")) {
            LinearLayout GNenek =  findViewById(R.id.GNenek);
            GNenek.setVisibility(View.GONE);
        }
        else {
            Nenek = Integer.parseInt(sNenek);
        }

        if (sSaudaraKandung.equals("0")) {
            LinearLayout GSaudaraKandung =  findViewById(R.id.GSaudaraKandung);
            GSaudaraKandung.setVisibility(View.GONE);
        }
        else {
            SaudaraKandung = Integer.parseInt(sSaudaraKandung);
        }

        if (sSaudariKandung.equals("0")) {
            LinearLayout GSaudariKandung =  findViewById(R.id.GSaudariKandung);
            GSaudariKandung.setVisibility(View.GONE);
        }
        else {
            SaudariKandung = Integer.parseInt(sSaudariKandung);
        }

        //akhir state

        //penghitungan harta pewaris
        int intharta = Integer.parseInt(jumlahHarta);
        final int intHutang = Integer.parseInt(Hutang);
        final int intPengurusanJenazah = Integer.parseInt(PengurusanJenazah);
        int intWasiat = Integer.parseInt(Wasiat);

        int total = intharta - intHutang - intPengurusanJenazah - intWasiat;
        final int harta = intharta - intHutang - intPengurusanJenazah - intWasiat;

        //jika tidak punya anak
        if(AnakLakilaki==0 & AnakPerempuan==0){
            //jika tidak punya Suami/Istri
            if(Suami==0 && Istri==0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        sisa = harta;
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(SaudariKandung==1){
                                            SaudariKandung = harta / 2;
                                            sisa = harta - SaudariKandung;
                                        }
                                        else if(SaudariKandung>1){
                                            SaudariKandung = (harta * 2) / 3;
                                            sisa = harta - SaudariKandung;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        SaudaraKandung = harta;
                                    }
                                    else if(SaudariKandung>0){
                                        sisa = harta;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }

                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        Nenek = harta / 6;
                                        sisa = harta - Nenek;
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(SaudariKandung==1){
                                            Nenek = harta / 6;
                                            SaudariKandung = harta / 2;
                                            sisa = harta - Nenek - SaudariKandung;
                                        }
                                        else if(SaudariKandung>1){
                                            Nenek = harta / 6;
                                            SaudariKandung = (harta * 2) / 3;
                                            sisa = harta - Nenek - SaudariKandung;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        Nenek = harta / 6;
                                        SaudaraKandung = 0;
                                        sisa = harta - Nenek - SaudaraKandung;
                                    }
                                    else if(SaudariKandung>0){
                                        Nenek = harta / 6;
                                        sisa = harta;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            if(Nenek==0){
                                Kakek = harta;
                            }
                            else if(Nenek>0){
                                Nenek = harta / 6;
                                Kakek = 0;
                                sisa = harta - Nenek - Kakek;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        if(Kakek==0){
                            //jika tidak punya saudara kandung
                            if(SaudaraKandung==0){
                                //jika tidak punya saudari kandung
                                if(SaudariKandung==0){
                                    Ibu = harta / 3;
                                }
                                //jika punya saudari kandung (ar-raad)
                                else if(SaudariKandung>0){
                                    if(SaudariKandung==1){
                                        Ibu = (harta * 2) / 5;
                                        SaudariKandung = (harta * 3) / 5;
                                    }
                                    else if(SaudariKandung>1){
                                        Ibu = harta / 5;
                                        SaudariKandung = (harta * 4) / 5;
                                    }
                                }
                            }
                            //jika punya saudara kandung
                            else if(SaudaraKandung>0){
                                if(SaudariKandung==0){
                                    Ibu = harta / 3;
                                    SaudaraKandung = harta - Ibu;
                                }
                                else if(SaudariKandung>0){
                                    Ibu = harta / 3;
                                    sisa = harta - Ibu;
                                    Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                    SaudaraKandung = Bagian * 2;
                                    SaudariKandung = Bagian;
                                }
                            }
                        }
                        else if(Kakek>0){
                            Ibu = harta / 3;
                            Kakek = harta - Ibu;
                        }
                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    if(Ibu==0){
                        Ayah = harta;
                    }
                    else if(Ibu>0){
                        Ibu = harta / 3;
                        Ayah = harta - Ibu;
                    }
                }

            }
            //jika punya Suami atau Istri
            else{
                //jika punya Suami
                if(Suami>0){
                    if(Ayah==0){
                        //jika tidak punya Ibu
                        if(Ibu==0){
                            //jika tidakpunya Kakek
                            if(Kakek==0){
                                //jika tidak punya Nenek
                                if(Nenek==0){
                                    //jika tidak punya saudara kandung
                                    if(SaudaraKandung==0){
                                        //jika tidak punya saudari kandung
                                        if(SaudariKandung==0){
                                            Suami = harta / 2;
                                            sisa = harta - Suami;
                                        }
                                        //jika punya saudari kandung
                                        else if(SaudariKandung>0){
                                            if(SaudariKandung==1){
                                                Suami = harta / 2;
                                                SaudariKandung = harta / 2;
                                            }
                                            //masalah aul
                                            else if(SaudariKandung>1){
                                                Suami = (harta * 3) / 7;
                                                SaudariKandung = (harta * 4) / 7;
                                            }

                                        }

                                    }
                                    //jika punya saudara kandung
                                    else if(SaudaraKandung>0){
                                        if(SaudariKandung==0){
                                            Suami = harta / 2;
                                            SaudaraKandung = harta - Suami;
                                        }
                                        else if(SaudariKandung>0){
                                            Suami = harta / 2;
                                            sisa = harta - Suami;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }

                                }
                                //jika punya Nenek
                                else if(Nenek>0){
                                    //jika tidak punya saudara kandung
                                    if(SaudaraKandung==0){
                                        //jika tidak punya saudari kandung
                                        if(SaudariKandung==0){
                                            Nenek = harta / 6;
                                            Suami = harta / 2;
                                            sisa = harta - Nenek - Suami;
                                        }
                                        //jika punya saudari kandung
                                        else if(SaudariKandung>0){
                                            Nenek = harta / 7;
                                            Suami = (harta * 3) / 7;
                                            SaudariKandung = (harta * 3) / 7;
                                        }

                                    }
                                    //jika punya saudara kandung
                                    else if(SaudaraKandung>0){
                                        if(SaudariKandung==0){
                                            Nenek = harta / 6;
                                            Suami = harta / 2;
                                            SaudaraKandung = harta - Nenek - Suami;
                                        }
                                        else if(SaudariKandung>0){
                                            Nenek = harta / 6;
                                            Suami = harta / 2;
                                            sisa = harta - Nenek - Suami;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }

                            }
                            //jika punya Kakek
                            else if(Kakek>0){
                                if(Nenek==0){
                                    Suami = harta / 2;
                                    Kakek = harta - Suami;
                                }
                                else if(Nenek>0){
                                    Suami = harta / 2;
                                    sisa = harta - Suami;
                                    Nenek = sisa / 2;
                                    Kakek = sisa / 2;
                                }
                            }

                        }
                        //jika punya Ibu
                        else if(Ibu>0){
                            if(Kakek==0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        Suami = harta / 2;
                                        Ibu = harta - Suami;
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        //aul
                                        if(SaudariKandung==1){
                                            Suami = (harta * 3) / 8;
                                            Ibu = (harta * 2) / 8;
                                            SaudariKandung = (harta * 3) / 8;
                                        }
                                        else if(SaudariKandung>0){
                                            Suami = (harta * 3) / 8;
                                            Ibu = harta / 8;
                                            SaudariKandung = (harta * 4) / 8;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        Suami = harta / 2;
                                        Ibu = harta / 3;
                                        SaudaraKandung = harta - Suami - Ibu;
                                    }
                                    else if(SaudariKandung>0){
                                        Suami = harta / 2;
                                        Ibu = harta / 6;
                                        sisa = harta - Suami - Ibu;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }
                            }
                            else if(Kakek>0){
                                Suami = harta / 2;
                                Ibu = harta / 3;
                                Kakek = harta - Suami - Ibu;
                            }
                        }

                    }
                    //jika punya Ayah
                    else if(Ayah>0){
                        if(Ibu==0){
                            Suami = harta / 2;
                            Ayah = harta - Suami;
                        }
                        else if(Ibu>0){
                            Suami = harta / 2;
                            sisa = harta - Suami;
                            Bagian = sisa / ((2 * Ayah) + Ibu);
                            Ayah = Bagian * 2;
                            Ibu = Bagian;
                        }
                    }
                }
                //jika punya Istri
                else if(Istri>0){
                    if(Ayah==0){
                        //jika tidak punya Ibu
                        if(Ibu==0){
                            //jika tidakpunya Kakek
                            if(Kakek==0){
                                //jika tidak punya Nenek
                                if(Nenek==0){
                                    //jika tidak punya saudara kandung
                                    if(SaudaraKandung==0){
                                        //jika tidak punya saudari kandung
                                        if(SaudariKandung==0){
                                            Istri = harta / 4;
                                            sisa = harta - Istri;
                                        }
                                        //jika punya saudari kandung
                                        else if(SaudariKandung>0){
                                            if(SaudariKandung==1){
                                                Istri = harta / 4;
                                                SaudariKandung = harta / 2;
                                            }
                                            //masalah aul
                                            else if(SaudariKandung>1){
                                                //bingung
                                            }

                                        }

                                    }
                                    //jika punya saudara kandung
                                    else if(SaudaraKandung>0){
                                        if(SaudariKandung==0){
                                            Istri = harta / 4;
                                            SaudaraKandung = harta - Istri;
                                        }
                                        else if(SaudariKandung>0){
                                            Istri = harta / 4;
                                            sisa = harta - Istri;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }

                                }
                                //jika punya Nenek
                                else if(Nenek>0){
                                    //jika tidak punya saudara kandung
                                    if(SaudaraKandung==0){
                                        //jika tidak punya saudari kandung
                                        if(SaudariKandung==0){
                                            Nenek = harta / 6;
                                            Istri = harta / 4;
                                            sisa = harta - Nenek - Istri;
                                        }
                                        //jika punya saudari kandung
                                        else if(SaudariKandung>0){
                                            //raad
                                            if(SaudariKandung==1){
                                                Istri = harta / 4;
                                                Nenek = harta / 4;
                                                SaudariKandung = (harta * 3) / 4;
                                            }
                                            //aul
                                            else if(SaudariKandung>1){
                                                Istri = (harta * 3) / 13;
                                                Nenek = (harta * 2) / 13;
                                                SaudariKandung = (harta * 8) / 13;
                                            }

                                        }

                                    }
                                    //jika punya saudara kandung
                                    else if(SaudaraKandung>0){
                                        if(SaudariKandung==0){
                                            Nenek = harta / 6;
                                            Istri = harta / 4;
                                            SaudaraKandung = harta - Nenek - Istri;
                                        }
                                        else if(SaudariKandung>0){
                                            Nenek = harta / 6;
                                            Istri = harta / 4;
                                            sisa = harta - Nenek - Istri;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }

                            }
                            //jika punya Kakek
                            else if(Kakek>0){
                                if(Nenek==0){
                                    Istri = harta / 4;
                                    Kakek = harta - Suami;
                                }
                                else if(Nenek>0){
                                    Istri = harta / 4;
                                    Nenek = harta / 6;
                                    Kakek = harta - Istri - Nenek;
                                }
                            }

                        }
                        //jika punya Ibu
                        else if(Ibu>0){
                            if(Kakek==0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        Istri = harta / 4;
                                        Ibu = harta - Istri;
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        //aul
                                        if(SaudariKandung==1){
                                            Istri = (harta * 3) / 13;
                                            Ibu = (harta * 4) / 13;
                                            SaudariKandung = (harta * 6) / 13;
                                        }
                                        else if(SaudariKandung>1){
                                            Suami = (harta * 3) / 13;
                                            Ibu = (harta * 2) / 13;
                                            SaudariKandung = (harta * 8) / 13;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        Istri = harta / 4;
                                        Ibu = harta / 3;
                                        SaudaraKandung = harta - Istri - Ibu;
                                    }
                                    else if(SaudariKandung>0){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        sisa = harta - Istri - Ibu;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }
                            }
                            else if(Kakek>0){
                                Istri = harta / 4;
                                Ibu = harta / 3;
                                Kakek = harta - Istri - Ibu;
                            }
                        }

                    }
                    //jika punya Ayah
                    else if(Ayah>0){
                        if(Ibu==0){
                            Istri = harta / 4;
                            Ayah = harta - Suami;
                        }
                        else if(Ibu>0){
                            Istri = harta / 4;
                            sisa = harta - Istri;
                            Bagian = sisa / ((2 * Ayah) + Ibu);
                            Ayah = Bagian * 2;
                            Ibu = Bagian;
                        }
                    }
                }

            }
        }

        //jika tidak punya anak perempuan tetapi punya anak laki-laki
        else if(AnakPerempuan==0){
            //jika punya Suami
            if(Suami>0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Suami = harta / 4;
                                AnakLakilaki = harta - Suami;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Suami = harta / 4;
                                Nenek = harta / 6;
                                AnakLakilaki = harta - Suami - Nenek;
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Suami = harta / 4;
                                Kakek = harta / 6;
                                AnakLakilaki = harta - Suami - Kakek;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Suami = harta / 4;
                                Kakek = harta / 6;
                                Nenek = harta / 6;
                                AnakLakilaki = harta - Suami - Kakek - Nenek;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            Suami = harta / 4;
                            Ibu = harta / 6;
                            AnakLakilaki = harta - Suami - Ibu;
                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            Suami = harta / 4;
                            Ibu = harta / 6;
                            Kakek = harta / 6;
                            AnakLakilaki = harta - Suami - Ibu - Kakek;
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        Suami = harta / 4;
                        Ayah = harta / 6;
                        AnakLakilaki = harta - Suami - Ayah;
                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        Suami = harta / 4;
                        Ayah = harta / 6;
                        Ibu = harta / 6;
                        AnakLakilaki = harta - Suami - Ayah - Ibu;
                    }
                }
            }

            //jika punya Istri
            else if(Istri>0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Istri = harta / 8;
                                AnakLakilaki = harta - Istri;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Istri = harta / 8;
                                Nenek = harta / 6;
                                AnakLakilaki = harta - Istri - Nenek;
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Istri = harta / 8;
                                Kakek = harta / 6;
                                AnakLakilaki = harta - Istri - Kakek;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Istri = harta / 8;
                                Kakek = harta / 6;
                                Nenek = harta / 6;
                                AnakLakilaki = harta - Istri - Kakek - Nenek;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            Istri = harta / 8;
                            Ibu = harta / 6;
                            AnakLakilaki = harta - Istri - Ibu;
                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            Istri = harta / 8;
                            Ibu = harta / 6;
                            Kakek = harta / 6;
                            AnakLakilaki = harta - Istri - Ibu - Kakek;
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        Istri = harta / 8;
                        Ayah = harta / 6;
                        AnakLakilaki = harta - Istri - Ayah;
                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        Istri = harta / 8;
                        Ayah = harta / 6;
                        Ibu = harta / 6;
                        AnakLakilaki = harta - Istri - Ayah - Ibu;
                    }
                }
            }
            //jika tidak punya Suami dan Istri
            else if(Suami==0 && Istri==0){
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                AnakLakilaki = harta;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Nenek = harta / 6;
                                AnakLakilaki = 0;
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Kakek = harta / 6;
                                AnakLakilaki = harta - Kakek;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Kakek = harta / 6;
                                Nenek = harta / 6;
                                AnakLakilaki = harta - Kakek - Nenek;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidak punya Kakek
                        if(Kakek==0){
                            Ibu = harta / 6;
                            AnakLakilaki = harta - Ibu;
                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            Ibu = harta / 6;
                            Kakek = harta / 6;
                            AnakLakilaki = harta - Ibu - Kakek;
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        Ayah = harta / 6;
                        AnakLakilaki = harta - Ayah;
                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        Ayah = harta / 6;
                        Ibu = harta / 6;
                        AnakLakilaki = harta - Ayah - Ibu;
                    }
                }
            }

        }

        //jika tidak punya anak laki-laki tetapi punya anak perempuan
        else if(AnakLakilaki==0){
            //jika punya Suami
            if(Suami>0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        //bingung
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Suami = harta / 4;
                                            AnakPerempuan = harta / 2;
                                            SaudariKandung = harta - Suami - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Suami = harta / 4;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudariKandung = harta - Suami - AnakPerempuan;
                                        }

                                    }

                                }
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            Suami = harta / 4;
                                            AnakPerempuan = harta / 2;
                                            SaudaraKandung = harta - Suami - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Suami = harta / 4;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudaraKandung = harta - Suami - AnakPerempuan;
                                        }

                                    }
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Suami = harta / 4;
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - Suami - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                        else if(AnakPerempuan>1){
                                            Suami = harta / 4;
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - Suami - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        // AnakPerempuan = (harta * 2) / 3;
                                        // Nenek = harta / 6;
                                        //bingung
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Suami = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            SaudariKandung = harta - Suami - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Suami = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudariKandung = harta - Suami - Nenek - AnakPerempuan;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            Suami = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            SaudaraKandung = harta - Suami - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Suami = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudaraKandung = harta - Suami - Nenek - AnakPerempuan;
                                        }
                                    }
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Suami = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - Suami - Nenek - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                        else if(AnakPerempuan>1){
                                            Suami = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - Suami - Nenek - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }

                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                if(AnakPerempuan==1){
                                    Suami = harta / 4;
                                    AnakPerempuan = harta / 2;
                                    sisa = harta - Suami - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }
                                else if(AnakPerempuan>1){
                                    Suami = harta / 4;
                                    AnakPerempuan = (harta * 2) / 3;
                                    sisa = harta - Suami - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                //aul
                                if(AnakPerempuan==1){
                                    Suami = (harta * 3) / 13;
                                    Nenek = (harta * 2) / 13;
                                    AnakPerempuan = (harta * 6) / 13;
                                    Kakek = (harta * 2) / 13;
                                }
                                else if(AnakPerempuan>1){
                                    Suami = (harta * 3) / 15;
                                    Nenek = (harta * 2) / 15;
                                    AnakPerempuan = (harta * 8) / 15;
                                    Kakek = (harta * 2) / 15;
                                }
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya saudara kandung
                            if(SaudaraKandung==0){
                                //jika tidak punya saudari kandung
                                if(SaudariKandung==0){
                                    //raad
                                    if(AnakPerempuan==1){
                                        Ibu = harta / 4;
                                        AnakPerempuan = (harta * 3) / 4;
                                    }
                                    else if(AnakPerempuan>1){
                                        Ibu = harta / 5;
                                        AnakPerempuan = (harta * 4) / 5;
                                    }

                                }
                                //jika punya saudari kandung
                                else if(SaudariKandung>0){
                                    if(AnakPerempuan==1){
                                        Suami = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        SaudariKandung = harta - Suami - Ibu - AnakPerempuan;
                                    }
                                    else if(AnakPerempuan>1){
                                        Suami = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        SaudariKandung = harta - Suami - Ibu - AnakPerempuan;
                                    }
                                }

                            }
                            //jika punya saudara kandung
                            else if(SaudaraKandung>0){
                                if(SaudariKandung==0){
                                    if(AnakPerempuan==1){
                                        Suami = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        SaudaraKandung = harta - Suami - Ibu - AnakPerempuan;
                                    }
                                    else if(AnakPerempuan>1){
                                        Suami = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        SaudaraKandung = harta - Suami - Ibu - AnakPerempuan;
                                    }

                                }
                                else if(SaudariKandung>0){
                                    if(AnakPerempuan==1){
                                        Suami = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        sisa = harta - Suami - Ibu - AnakPerempuan;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                    else if(AnakPerempuan>1){
                                        Suami = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        sisa = harta - Suami - Ibu - AnakPerempuan;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            if(AnakPerempuan==1){
                                //aul
                                Suami = (harta * 3) / 13;
                                Ibu = (harta * 2) / 13;
                                AnakPerempuan = (harta * 6) / 13;
                                Kakek = (harta * 2) / 13;
                            }
                            else if(AnakPerempuan>1){
                                Suami = (harta * 3) / 15;
                                Ibu = (harta * 2) / 15;
                                AnakPerempuan = (harta * 8) / 15;
                                Kakek = (harta * 2) / 15;
                            }

                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        if(AnakPerempuan==1){
                            Suami = harta / 4;
                            AnakPerempuan = harta / 2;
                            sisa = harta - Suami - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }
                        else if(AnakPerempuan>1){
                            Suami = harta / 4;
                            AnakPerempuan = (harta * 2) / 3;
                            sisa = harta - Suami - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //aul
                        if(AnakPerempuan==1){
                            Suami = (harta * 3) / 13;
                            Ibu = (harta * 2) / 13;
                            AnakPerempuan = (harta * 6) / 13;
                            Ayah = (harta * 2) / 13;
                        }
                        else if(AnakPerempuan>1){
                            Suami = (harta * 3) / 15;
                            Ibu = (harta * 2) / 15;
                            AnakPerempuan = (harta * 8) / 15;
                            Ayah = (harta * 2) / 15;
                        }
                    }
                }
            }
            //jika punya Istri
            if(Istri>0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidak punya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        //raad
                                        if(AnakPerempuan==1){

                                        }
                                        else if(AnakPerempuan>1){

                                        }

                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Istri = harta / 4;
                                            AnakPerempuan = harta / 2;
                                            SaudariKandung = harta - Istri - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Istri = harta / 4;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudariKandung = harta - Istri - AnakPerempuan;
                                        }

                                    }

                                }
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            Istri = harta / 4;
                                            AnakPerempuan = harta / 2;
                                            SaudaraKandung = harta - Istri - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Istri = harta / 4;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudaraKandung = harta - Istri - AnakPerempuan;
                                        }

                                    }
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Istri = harta / 4;
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - Istri - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                        else if(AnakPerempuan>1){
                                            Istri = harta / 4;
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - Istri - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        // AnakPerempuan = (harta * 2) / 3;
                                        // Nenek = harta / 6;
                                        //bingung
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Istri = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            SaudariKandung = harta - Istri - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Istri = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudariKandung = harta - Istri - Nenek - AnakPerempuan;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            Istri = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            SaudaraKandung = harta - Istri - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Istri = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudaraKandung = harta - Istri - Nenek - AnakPerempuan;
                                        }
                                    }
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Istri = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - Istri - Nenek - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                        else if(AnakPerempuan>1){
                                            Istri = harta / 4;
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - Istri - Nenek - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }

                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                if(AnakPerempuan==1){
                                    Istri = harta / 4;
                                    AnakPerempuan = harta / 2;
                                    sisa = harta - Istri - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }
                                else if(AnakPerempuan>1){
                                    Istri = harta / 4;
                                    AnakPerempuan = (harta * 2) / 3;
                                    sisa = harta - Istri - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                //aul
                                if(AnakPerempuan==1){
                                    Istri = (harta * 3) / 13;
                                    Nenek = (harta * 2) / 13;
                                    AnakPerempuan = (harta * 6) / 13;
                                    Kakek = (harta * 2) / 13;

                                }
                                else if(AnakPerempuan>1){
                                    Istri = (harta * 3) / 15;
                                    Nenek = (harta * 2) / 15;
                                    AnakPerempuan = (harta * 8) / 15;
                                    Kakek = (harta * 2) / 15;
                                }
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya saudara kandung
                            if(SaudaraKandung==0){
                                //jika tidak punya saudari kandung
                                if(SaudariKandung==0){
                                    //bingung
                                }
                                //jika punya saudari kandung
                                else if(SaudariKandung>0){
                                    if(AnakPerempuan==1){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        SaudariKandung = harta - Istri - Ibu - AnakPerempuan;
                                    }
                                    else if(AnakPerempuan>1){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        SaudariKandung = harta - Istri - Ibu - AnakPerempuan;
                                    }
                                }

                            }
                            //jika punya saudara kandung
                            else if(SaudaraKandung>0){
                                if(SaudariKandung==0){
                                    if(AnakPerempuan==1){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        SaudaraKandung = harta - Istri - Ibu - AnakPerempuan;
                                    }
                                    else if(AnakPerempuan>1){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        SaudaraKandung = harta - Istri - Ibu - AnakPerempuan;
                                    }

                                }
                                else if(SaudariKandung>0){
                                    if(AnakPerempuan==1){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        sisa = harta - Istri - Ibu - AnakPerempuan;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                    else if(AnakPerempuan>1){
                                        Istri = harta / 4;
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        sisa = harta - Istri - Ibu - AnakPerempuan;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            if(AnakPerempuan==1){
                                //aul
                                Istri = (harta * 3) / 13;
                                Ibu = (harta * 2) / 13;
                                AnakPerempuan = (harta * 6) / 13;
                                Kakek = (harta * 2) / 13;
                            }
                            else if(AnakPerempuan>1){
                                Istri = (harta * 3) / 15;
                                Ibu = (harta * 2) / 15;
                                AnakPerempuan = (harta * 8) / 15;
                                Kakek = (harta * 2) / 15;
                            }

                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        if(AnakPerempuan==1){
                            Istri = harta / 4;
                            AnakPerempuan = harta / 2;
                            sisa = harta - Istri - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }
                        else if(AnakPerempuan>1){
                            Istri = harta / 4;
                            AnakPerempuan = (harta * 2) / 3;
                            sisa = harta - Istri - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //aul
                        if(AnakPerempuan==1){
                            Istri = (harta * 3) / 13;
                            Ibu = (harta * 2) / 13;
                            AnakPerempuan = (harta * 6) / 13;
                            Ayah = (harta * 2) / 13;
                        }
                        else if(AnakPerempuan>1){
                            Istri = (harta * 3) / 15;
                            Ibu = (harta * 2) / 15;
                            AnakPerempuan = (harta * 8) / 15;
                            Ayah = (harta * 2) / 15;
                        }
                    }
                }
            }
            //jika tidak punya Suami dan Istri
            else if(Suami==0 && Istri==0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            AnakPerempuan = harta / 2;
                                        }
                                        else if(AnakPerempuan>1){
                                            AnakPerempuan = (harta * 2) / 3;
                                        }

                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            AnakPerempuan = harta / 2;
                                            SaudariKandung = harta - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudariKandung = harta - AnakPerempuan;
                                        }
                                    }

                                }
                                //jika ada saudara kandung
                                else if(SaudaraKandung>0){
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            AnakPerempuan = harta / 2;
                                            SaudaraKandung = harta - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudaraKandung = harta - AnakPerempuan;
                                        }

                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                        else if(AnakPerempuan>1){
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                //jika tidak punya saudara kandung
                                if(SaudaraKandung==0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - Nenek - AnakPerempuan;
                                        }
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            SaudariKandung = harta - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudariKandung = harta - Nenek - AnakPerempuan;
                                        }
                                    }

                                }
                                //jika punya saudara kandung
                                else if(SaudaraKandung>0){
                                    //jika tidak punya saudari kandung
                                    if(SaudariKandung==0){
                                        if(AnakPerempuan==1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            SaudaraKandung = harta - Nenek - AnakPerempuan;
                                        }
                                        else if(AnakPerempuan>1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            SaudaraKandung = harta - Nenek - AnakPerempuan;
                                        }
                                    }
                                    //jika punya saudari kandung
                                    else if(SaudariKandung>0){
                                        if(AnakPerempuan==1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = harta / 2;
                                            sisa = harta - Nenek - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                        else if(AnakPerempuan>1){
                                            Nenek = harta / 6;
                                            AnakPerempuan = (harta * 2) / 3;
                                            sisa = harta - Nenek - AnakPerempuan;
                                            Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                            SaudaraKandung = Bagian * 2;
                                            SaudariKandung = Bagian;
                                        }
                                    }
                                }

                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                if(AnakPerempuan==1){
                                    AnakPerempuan = harta / 2;
                                    sisa = harta - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }
                                else if(AnakPerempuan>1){
                                    AnakPerempuan = (harta * 2) / 3;
                                    sisa = harta - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }

                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                if(AnakPerempuan==1){
                                    Nenek = harta / 6;
                                    AnakPerempuan = harta / 2;
                                    sisa = harta - Nenek - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }
                                else if(AnakPerempuan>1){
                                    Nenek = harta / 6;
                                    AnakPerempuan = (harta * 2) / 3;
                                    sisa = harta - Nenek - AnakPerempuan;
                                    Kakek = (harta / 6) + sisa;
                                }

                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya saudara kandung
                            if(SaudaraKandung==0){
                                //jika tidak punya saudari kandung
                                if(SaudariKandung==0){
                                    if(AnakPerempuan==1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                    }
                                    else if(AnakPerempuan>1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                    }
                                }
                                //jika punya saudari kandung
                                else if(SaudariKandung>0){
                                    if(AnakPerempuan==1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        SaudariKandung = harta - Ibu - AnakPerempuan;
                                    }
                                    else if(AnakPerempuan>1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        SaudariKandung = harta - Ibu - AnakPerempuan;
                                    }
                                }

                            }
                            //jika punya saudara kandung
                            else if(SaudaraKandung>0){
                                //jika tidak punya saudari kandung
                                if(SaudariKandung==0){
                                    if(AnakPerempuan==1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        SaudaraKandung = harta - Ibu - SaudaraKandung;
                                    }
                                    else if(AnakPerempuan>1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        SaudaraKandung = harta - Ibu - SaudaraKandung;
                                    }
                                }
                                //jika punya saudari kandung
                                else if(SaudariKandung>0){
                                    if(AnakPerempuan==1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = harta / 2;
                                        sisa = harta - Ibu - AnakPerempuan;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                    else if(AnakPerempuan>1){
                                        Ibu = harta / 6;
                                        AnakPerempuan = (harta * 2) / 3;
                                        sisa = harta - Ibu - AnakPerempuan;
                                        Bagian = sisa / ((2 * SaudaraKandung) + SaudariKandung);
                                        SaudaraKandung = Bagian * 2;
                                        SaudariKandung = Bagian;
                                    }
                                }
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            if(AnakPerempuan==1){
                                Ibu = harta / 6;
                                AnakPerempuan = harta / 2;
                                sisa = harta - Ibu - AnakPerempuan;
                                Kakek = (harta / 6) + sisa;
                            }
                            else if(AnakPerempuan>1){
                                Ibu = harta / 6;
                                AnakPerempuan = (harta * 2) / 3;
                                sisa = harta - Ibu - AnakPerempuan;
                                Kakek = (harta / 6) + sisa;
                            }
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        if(AnakPerempuan==1){
                            AnakPerempuan = harta / 2;
                            sisa = harta - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }
                        else if(AnakPerempuan>1){
                            AnakPerempuan = (harta * 2) / 3;
                            sisa = harta - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        if(AnakPerempuan==1){
                            Ibu = harta / 6;
                            AnakPerempuan = harta / 2;
                            sisa = harta - Ibu - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }
                        else if(AnakPerempuan>1){
                            Ibu = harta / 6;
                            AnakPerempuan = (harta * 2) / 3;
                            sisa = harta - Ibu - AnakPerempuan;
                            Ayah = (harta / 6) + sisa;
                        }
                    }
                }
            }

        }
        //jika punya anak laki-laki dan perempuan
        else if(AnakLakilaki>0 && AnakPerempuan>0){
            //jika punya Suami
            if(Suami>0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Suami = harta / 4;
                                sisa = harta - Suami;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Suami = harta / 4;
                                Nenek = harta / 6;
                                sisa = harta - Suami - Nenek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Suami = harta / 4;
                                Kakek = harta / 6;
                                sisa = harta - Suami - Kakek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Suami = harta / 4;
                                Kakek = harta / 6;
                                Nenek = harta / 6;
                                sisa = harta - Suami - Kakek - Nenek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            Suami = harta / 4;
                            Ibu = harta / 6;
                            sisa = harta - Suami - Ibu;
                            Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                            AnakLakilaki = Bagian * 2;
                            AnakPerempuan = Bagian;
                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            Suami = harta / 4;
                            Ibu = harta / 6;
                            Kakek = harta / 6;
                            sisa = harta - Suami - Ibu - Kakek;
                            Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                            AnakLakilaki = Bagian * 2;
                            AnakPerempuan = Bagian;
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        Suami = harta / 4;
                        Ayah = harta / 6;
                        sisa = harta - Suami - Ayah;
                        Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                        AnakLakilaki = Bagian * 2;
                        AnakPerempuan = Bagian;
                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        Suami = harta / 4;
                        Ayah = harta / 6;
                        Ibu = (harta - Suami - Ayah) / 3;
                        sisa = harta - Suami - Ayah - Ibu;
                        Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                        AnakLakilaki = Bagian * 2;
                        AnakPerempuan = Bagian;
                    }
                }
            }

            //jika punya Istri
            else if(Istri>0){
                //jika tidak punya Ayah
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Istri = harta / 8;
                                sisa = harta - Istri;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Istri = harta / 8;
                                Nenek = harta / 6;
                                sisa = harta - Istri - Nenek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Istri = harta / 8;
                                Kakek = harta / 6;
                                sisa = harta - Istri - Kakek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Istri = harta / 8;
                                Kakek = harta / 6;
                                Nenek = harta / 6;
                                sisa = harta - Istri - Kakek - Nenek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            Istri = harta / 8;
                            Ibu = harta / 6;
                            sisa = harta - Istri - Ibu;
                            Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                            AnakLakilaki = Bagian * 2;
                            AnakPerempuan = Bagian;
                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            Istri = harta / 8;
                            Ibu = harta / 6;
                            Kakek = harta / 6;
                            sisa = harta - Istri - Ibu - Kakek;
                            Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                            AnakLakilaki = Bagian * 2;
                            AnakPerempuan = Bagian;
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        Istri = harta / 8;
                        Ayah = harta / 6;
                        sisa = harta - Istri - Ayah;
                        Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                        AnakLakilaki = Bagian * 2;
                        AnakPerempuan = Bagian;
                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        Istri = harta / 8;
                        Ayah = harta / 6;
                        Ibu = (harta - Istri - Ayah) / 3;
                        sisa = harta - Istri - Ayah - Ibu;
                        Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                        AnakLakilaki = Bagian * 2;
                        AnakPerempuan = Bagian;
                    }
                }
            }
            //jika tidak punya Suami dan Istri
            else if(Suami==0 && Istri==0){
                if(Ayah==0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        //jika tidakpunya Kakek
                        if(Kakek==0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                sisa = harta;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Nenek = harta / 6;
                                sisa = harta - Nenek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }

                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            //jika tidak punya Nenek
                            if(Nenek==0){
                                Kakek = harta / 6;
                                sisa = harta - Kakek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                            //jika punya Nenek
                            else if(Nenek>0){
                                Kakek = harta / 6;
                                Nenek = harta / 6;
                                sisa = harta - Kakek - Nenek;
                                Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                                AnakLakilaki = Bagian * 2;
                                AnakPerempuan = Bagian;
                            }
                        }

                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        //jika tidak punya Kakek
                        if(Kakek==0){
                            Ibu = harta / 6;
                            sisa = harta - Ibu;
                            Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                            AnakLakilaki = Bagian * 2;
                            AnakPerempuan = Bagian;
                        }
                        //jika punya Kakek
                        else if(Kakek>0){
                            Ibu = harta / 6;
                            Kakek = harta / 6;
                            sisa = harta - Ibu - Kakek;
                            Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                            AnakLakilaki = Bagian * 2;
                            AnakPerempuan = Bagian;
                        }

                    }

                }
                //jika punya Ayah
                else if(Ayah>0){
                    //jika tidak punya Ibu
                    if(Ibu==0){
                        Ayah = harta / 6;
                        sisa = harta - Ayah;
                        Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                        AnakLakilaki = Bagian * 2;
                        AnakPerempuan = Bagian;
                    }
                    //jika punya Ibu
                    else if(Ibu>0){
                        Ayah = harta / 6;
                        Ibu = (harta - Ayah) / 3;
                        sisa = harta - Ayah - Ibu;
                        Bagian = sisa / ((2 * AnakLakilaki) + AnakPerempuan);
                        AnakLakilaki = Bagian * 2;
                        AnakPerempuan = Bagian;
                    }
                }
            }
        }

        // ---------------------------
        final TextView tvNama = findViewById(R.id.showNama);
        final TextView tvJK =  findViewById(R.id.showJK);
        final TextView tvHarta =  findViewById(R.id.RpJumlah);
        final TextView tvHutang =  findViewById(R.id.RpHutang);
        final TextView tvPengurusanJenazah =  findViewById(R.id.RpPengurusanJenazah);
        final TextView tvWasiat =  findViewById(R.id.RpWasiat);
        final TextView tvJumlah =  findViewById(R.id.RpTotal);

        //memasukkan nilai data pewaris
        String sTotal = Integer.toString(total);
        tvNama.setText(Nama);
        tvJK.setText(JK);
        tvHarta.setText("Rp. "+jumlahHarta);
        tvHutang.setText("Rp. "+Hutang);
        tvPengurusanJenazah.setText("Rp. "+PengurusanJenazah);
        tvWasiat.setText("Rp. "+Wasiat);
        tvJumlah.setText("Rp. "+sTotal);

        //menyimpan variabel hasil hitungan ke string
        //karena textview tidak bisa membaca int
        final String ssAnakLakilaki = Integer.toString(AnakLakilaki);
        final String ssAnakPerempuan = Integer.toString(AnakPerempuan);

        String ssSuami = Integer.toString(Suami);
        String ssIstri = Integer.toString(Istri);

        String ssAyah = Integer.toString(Ayah);
        String ssIbu = Integer.toString(Ibu);

        String ssKakek = Integer.toString(Kakek);
        String ssNenek = Integer.toString(Nenek);

        String ssSaudaraKandung = Integer.toString(SaudaraKandung);
        String ssSaudariKandung = Integer.toString(SaudariKandung);

        //----------------------------------------------------------------------------------------------------------

        final TextView AnakLakilaki1 =  findViewById(R.id.AnakLakilaki1);
        final TextView AnakPerempuan1 =  findViewById(R.id.AnakPerempuan1);

        final TextView Suami1 =  findViewById(R.id.Suami1);
        final TextView Istri1 =  findViewById(R.id.Istri1);

        final TextView Ayah1 =  findViewById(R.id.Ayah1);
        final TextView Ibu1 =  findViewById(R.id.Ibu1);

        final TextView Kakek1 =  findViewById(R.id.Kakek1);
        final TextView Nenek1 =  findViewById(R.id.Nenek1);

        final TextView SaudaraKandung1 = findViewById(R.id.SaudaraKandung1);
        final TextView SaudariKandung1 =  findViewById(R.id.SaudariKandung1);

        //memasukkan nilai ke textview
        AnakLakilaki1.setText("Rp. "+ssAnakLakilaki);
        AnakPerempuan1.setText("Rp. "+ssAnakPerempuan);

        Suami1.setText("Rp. "+ssSuami);
        Istri1.setText("Rp. "+ssIstri);

        Ayah1.setText("Rp. "+ssAyah);
        Ibu1.setText("Rp. "+ssIbu);

        Kakek1.setText("Rp. "+ssKakek);
        Nenek1.setText("Rp. "+ssNenek);

        SaudaraKandung1.setText("Rp. "+ssSaudaraKandung);
        SaudariKandung1.setText("Rp. "+ssSaudariKandung);

        simpan.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            SQLiteDatabase db = dbSql.getWritableDatabase();
            db.execSQL("INSERT INTO data_pewaris (nama_pewaris, jenis_kelamin, jumlah_harta, jumlah_utang, jumlah_urus, jumlah_wasiat, total) VALUES ('" +
                    tvNama.getText().toString() + "','" +
                    tvJK.getText().toString() + "','" +
                    tvHarta.getText().toString() + "','" +
                    tvHutang.getText().toString() + "','" +
                    tvPengurusanJenazah.getText().toString() + "','" +
                    tvWasiat.getText().toString() + "','" +
                    tvJumlah.getText().toString() + "');");
            db.execSQL("INSERT INTO data_ahli_waris (nama_pewaris, anak_lk, anak_pr, suami, istri, ayah, ibu, kakek, nenek, sdra_kandung, sdri_kandung) VALUES ('" +
                    tvNama.getText().toString() + "','" +
                    AnakLakilaki1.getText().toString() + "','" +
                    AnakPerempuan1.getText().toString() + "','" +
                    Suami1.getText().toString() + "','" +
                    Istri1.getText().toString() + "','" +
                    Ayah1.getText().toString() + "','" +
                    Ibu1.getText().toString() + "','" +
                    Kakek1.getText().toString() + "','" +
                    Nenek1.getText().toString() + "','" +
                    SaudaraKandung1.getText().toString() + "','" +
                    SaudariKandung1.getText().toString() + "');");
            ListPewaris.lp.RefreshList();
            finish();
        });

        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());

    }

    private int harta(int i) {
        // TODO Auto-generated method stub
        return i;


}
}