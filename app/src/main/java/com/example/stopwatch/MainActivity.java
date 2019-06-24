package com.example.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import static android.os.SystemClock.elapsedRealtime;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    public void startchronometer(View v)
    {
        if(!running)
        {
            chronometer.setBase(elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pausechronometer(View v)
    {
        if(running)
        {
            chronometer.stop();
            pauseOffset = elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetchronometer(View v)
    {
        chronometer.setBase(elapsedRealtime());
        pauseOffset = 0;
    }
}
