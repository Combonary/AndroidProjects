package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    TextView timerTV;
    Button startButton, stopButton;
    double time;
    int trigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTV = findViewById(R.id.time_textView);

        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(v -> startCounter());

        stopButton = findViewById(R.id.stop_button2);
        stopButton.setOnClickListener(v -> stopCounter());

        time = 0.000;
        trigger = 0;

    }

    private void startCounter() {
        Runnable timer = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                trigger = 0;
                do {
                    time += 0.001;
                    timerTV.post(new Runnable() {
                        @Override
                        public void run() {
                            String formattedTime = String.format("%.3f" , time);
                            timerTV.setText("" + formattedTime);
                        }
                    });
                    Log.d(TAG, "run: ");
                }while (trigger == 0);
            }
        };
        new Thread(timer).start();

    }

    private void stopCounter() {
        trigger = 1;
    }
}