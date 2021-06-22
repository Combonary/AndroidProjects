package com.example.dynamiclayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.linear_layout);

        TextView first = new TextView(this);
        LayoutInflater layoutInflater = new LayoutInflater(this) {
            @Override
            public LayoutInflater cloneInContext(Context newContext) {
                return null;
            }
        };

        first.setText("This is my first attempt at dynamic layouts");
        layout.addView(first);
    }
}