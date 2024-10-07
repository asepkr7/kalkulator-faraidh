package com.example.myfaraid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class ListPewaris extends AppCompatActivity {
    String[] daftar;
    ListView ListView1;
    Menu menu;
    protected Cursor cursor;
    DataSql dbcenter;
    public static ListPewaris lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pewaris);

        Button btn = findViewById(R.id.button2);

        btn.setOnClickListener(v -> {
            Intent p = new Intent(ListPewaris.this, Pewaris.class);
            startActivity(p);
        });

        lp = this;
        dbcenter = new DataSql(this);
        RefreshList();

        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM data_pewaris", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(0);
        }
        ListView1 = findViewById(R.id.listView1);
        ListView1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView1.setSelected(true);
        ListView1.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
            final String selection = daftar[arg2];
            final CharSequence[] dialogitem = {"Lihat Data", "Hapus Data"};
            AlertDialog.Builder builder = new AlertDialog.Builder(ListPewaris.this);
            builder.setTitle("Pilihan");
            builder.setItems(dialogitem, (dialog, item) -> {
                switch(item){
                    case 0 : {
                        Intent i = new Intent(getApplicationContext(), Detail.class);
                        i.putExtra("nama_pewaris", selection);
                        startActivity(i);
                        break;
                    }
                    case 1 : {
                        SQLiteDatabase db1 = dbcenter.getWritableDatabase();
                        db1.execSQL("DELETE FROM data_pewaris where nama_pewaris = '"+selection+"'");
                        RefreshList();
                        break;
                    }
                }
            });
            builder.create().show();
        });
        ((ArrayAdapter) ListView1.getAdapter()).notifyDataSetInvalidated();

    }
}