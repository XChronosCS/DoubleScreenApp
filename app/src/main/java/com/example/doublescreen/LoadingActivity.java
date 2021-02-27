package com.example.doublescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadingActivity extends AppCompatActivity {
    private ProgressBar thinkingProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        thinkingProgressBar = (ProgressBar) findViewById(R.id.thinking_pb);
        barProgress();
    }

    public void barProgress(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    android.os.SystemClock.sleep(15);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            thinkingProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                if(mProgressStatus == 100){
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