package com.example.supportlibrariescl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private Button changeColorButton;
    private TextView helloTV;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTV = findViewById(R.id.hello_world_tv);
        changeColorButton = findViewById(R.id.change_text_btn);
        changeColorButton.setOnClickListener(v -> changeColor());

        if(savedInstanceState != null){
            helloTV.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", helloTV.getCurrentTextColor());
    }

    private void changeColor(){
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        /*int colorRes = getResources().getColor(colorResourceName, this.getTheme());*/
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        helloTV.setTextColor(colorRes);
    }
}