package com.demoapp.multiverse;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread th = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(3000);
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        th.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
