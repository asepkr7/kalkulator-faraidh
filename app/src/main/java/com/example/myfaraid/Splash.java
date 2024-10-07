package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final int welcomeScreenDisplay = 3000;

        Thread welcomeThread = new Thread() {

            int wait = 50;

            @Override
            public void run() {
                try {
                    super.run();
                    while (wait < welcomeScreenDisplay) {
                        sleep(100);
                        wait += 100;
                    }
                }
                catch (Exception e) {
                    System.out.println("EXc=" + e);
                }
                finally {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                }
            }
        };
        welcomeThread.start();

    }
    }
