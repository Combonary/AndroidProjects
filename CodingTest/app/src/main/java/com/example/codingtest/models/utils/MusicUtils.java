package com.example.codingtest.models.utils;

import android.util.Log;

import com.example.codingtest.models.Result;
import com.example.codingtest.models.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicUtils {

    private static final String TAG = MusicUtils.class.getSimpleName();

    private static List<Result> resultList;
    private static Root model = new Root();

    public static boolean parseJson(String response){
        try{
            final ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response, Root.class);
            initializeResultList();
            return true;
        }catch(IOException e){
            Log.d(TAG, "instance initializer: " + e.getMessage());
        }
        return false;
    }

    private static void initializeResultList(){
        resultList = new ArrayList<>();
        resultList = model.getResults();
    }

    public static List<Result> getResults(){
        return resultList;
    }
    public static String getTrackName(Result result){
        return result.getTrackName();
    }


}
