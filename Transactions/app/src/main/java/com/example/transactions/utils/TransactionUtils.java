package com.example.transactions.utils;

import android.util.Log;

import com.example.transactions.model.Transaction;
import com.example.transactions.model.Transactions;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {
    public static final String TAG = TransactionUtils.class.getSimpleName();

    private static Transactions transactionModel = new Transactions();
    private static ArrayList<Transaction> allTransactionsList;

    public static Transactions getTransactionModel() {
        return transactionModel;
    }

    public static void setTransactionModel(Transactions transactionModel) {
        TransactionUtils.transactionModel = transactionModel;
    }

    private static ObjectMapper getMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return objectMapper;
    }

    public static boolean parseJson(String jsonResponse){
        if(jsonResponse != null && jsonResponse.contains("transactions")){
            try{
                transactionModel = getMapper().readValue(jsonResponse, Transactions.class);
                setTransactionList();
                return true;
            }catch(IOException e){
                Log.d(TAG, "parseJson: there was an error while parsing server response");
            }
        }
        return false;
    }

    private static void setTransactionList() {
        allTransactionsList = new ArrayList<>();
        allTransactionsList = (ArrayList<Transaction>) getTransactionModel().getTransactions();
    }

    public static ArrayList<Transaction> getAllTransactionsList(){
        return allTransactionsList;
    }


}
