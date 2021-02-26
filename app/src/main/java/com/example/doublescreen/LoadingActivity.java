package com.example.doublescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadingActivity extends AppCompatActivity {
    private ProgressBar thinkingProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Timer startProgress = new Timer();
        startProgress.schedule(new LoadingThought(), 5);
        thinkingProgressBar = (ProgressBar) findViewById(R.id.thinking_pb);
    }

    class incrementBar extends Thread {
        public void run() {
            thinkingProgressBar.incrementProgressBy(2);
            if (thinkingProgressBar.getProgress() == 100) {
                launchActivity();
            }
        }
    }

    private void launchActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    class LoadingThought extends TimerTask{
        public void run(){
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(new incrementBar(), 0, 3, TimeUnit.MILLISECONDS);
            }
        }




}