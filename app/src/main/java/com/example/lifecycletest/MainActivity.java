package com.example.lifecycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Button btn_clicker;
    TextView tv_counter;

    int clicks = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickerValue", clicks);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicks = savedInstanceState.getInt("clickerValue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycleFilter", "The activity is paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycleFilter", "The activity is resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycleFilter", "The activity is started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycleFilter", "The activity is stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycleFilter", "The activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeCycleFilter", "The activity is restarted");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_clicker = findViewById(R.id.btn_clicker);
        tv_counter = findViewById(R.id.tv_counter);


        btn_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });

    }
}
