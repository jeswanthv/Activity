package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {
    private Button finishB;
    private android.widget.TextView threadCounterTextView;
    private int threadCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        finishB = findViewById(R.id.finishB);
        threadCounterTextView = findViewById(R.id.activitybtextview);
        if (getIntent() != null && getIntent().hasExtra("COUNTER_VALUE")) {
            threadCounter = getIntent().getIntExtra("COUNTER_VALUE", 0);
        }

        updateCounter();
        finishB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void updateCounter() {
        if (threadCounterTextView != null) {
            threadCounterTextView.setText(getString(R.string.activity_b_thread_counter_text, MainActivity.getRestartCounter()));
        }
    }





}