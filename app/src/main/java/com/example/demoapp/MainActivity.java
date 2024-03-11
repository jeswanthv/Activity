package com.example.demoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button startActivityBButton;
    private Button startActivityCButton;
    private Button showDialogButton;
    private Button closeAppButton;
    private TextView threadCounterTextView;
    private static int restartCounter = 0;

    public static int getRestartCounter() {
        return restartCounter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startActivityBButton = findViewById(R.id.startActivityBButton);
        startActivityCButton = findViewById(R.id.startActivityCButton);
        showDialogButton = findViewById(R.id.showDialogButton);
        closeAppButton = findViewById(R.id.closeAppButton);
        threadCounterTextView = findViewById(R.id.threadCounterTextView);


        setupButtonListeners();


        updateCounterTextView();
    }

    private void setupButtonListeners() {
        startActivityBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartCounter += 5;
                android.content.Intent intent = new
                        android.content.Intent(MainActivity.this, ActivityB.class);
                startActivity(intent);
            }
        });

        startActivityCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartCounter += 10;
                android.content.Intent intent = new
                        android.content.Intent(MainActivity.this, ActivityC.class);
                startActivity(intent);
            }
        });

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();
            }
        });

        closeAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Simple Dialog")
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        builder.create().show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        updateCounterTextView();
    }

    private void updateCounterTextView() {
        if (threadCounterTextView != null) {
            threadCounterTextView.setText("Thread Counter: " + String.format(Locale.getDefault(), "%04d", restartCounter));
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateCounterTextView();
    }
}
