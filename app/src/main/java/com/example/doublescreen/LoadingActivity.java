package com.example.doublescreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {
    private ProgressBar thinkingProgressBar;
    private int numProgress = 0;
    private final Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        thinkingProgressBar = (ProgressBar) findViewById(R.id.thinking_pb);
        barProgress();
    }

    public void barProgress() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (numProgress < 100) {
                    numProgress++;
                    android.os.SystemClock.sleep(15);
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            thinkingProgressBar.setProgress(numProgress);
                        }
                    });
                }
                if (numProgress == 100) {
                    launchActivity();
                }
            }
        }).start();

    }

    private void launchActivity() {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}