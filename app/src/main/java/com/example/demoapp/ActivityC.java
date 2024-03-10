package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity {
    private Button finishC;
    private android.widget.TextView threadCounterTextView;
    private int threadCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        finishC = findViewById(R.id.finishC);
        threadCounterTextView = findViewById(R.id.activityctextview);

        updateCounter();

        finishC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }







    private void updateCounter() {
        if (threadCounterTextView != null) {
            threadCounterTextView.setText(getString(R.string.activity_c_thread_counter_text, MainActivity.getRestartCounter()));
        }
    }


}