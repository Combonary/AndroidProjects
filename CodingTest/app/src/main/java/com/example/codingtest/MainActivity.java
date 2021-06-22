package com.example.codingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.codingtest.models.Result;
import com.example.codingtest.models.utils.MusicUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView trackListRecyclerView;
    String url = "https://itunes.apple.com/search?term=beyonce";
    List<Result> resultList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trackListRecyclerView = findViewById(R.id.track_names_rv);
        resultList = new ArrayList<>();
        loadList();
    }

    private void loadList() {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(url).build();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(MusicUtils.parseJson(response.toString())){
                    resultList = MusicUtils.getResults();
                    Log.d(TAG, "onResponse: "+ resultList.toString());
                }
            }
        });
    }
}