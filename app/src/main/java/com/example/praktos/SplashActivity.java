package com.example.praktos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;
    private Thread mSplashThread;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorisation);
        mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(SPLASH_TIME_OUT);
                    }
                } catch (InterruptedException e) {
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this, Authorisation.class);
                    startActivity(intent);
                    finish();
                    interrupt();
                }
            }
        };
        mSplashThread.start();
    }

}
