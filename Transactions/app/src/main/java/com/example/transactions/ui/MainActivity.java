package com.example.transactions.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transactions.R;
import com.example.transactions.model.Transaction;
import com.example.transactions.utils.TransactionConstants;
import com.example.transactions.utils.TransactionUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements TransactionAdapter.OnTransactionSelected {
    public static final String TAG = MainActivity.class.getSimpleName();
    ArrayList<Transaction> listOfTransactions;
    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.transactions_recyclerview);

        try {
            //load initial data
            run();
        } catch (IOException e) {
            Log.d(TAG, "onCreate: " + e.getMessage());
        }

    }

    private void run() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request initialRequest = new Request.Builder()
                .url(TransactionConstants.API_URL)
                .build();
        client.newCall(initialRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String initialResponse = Objects.requireNonNull(response.body()).string();
                TransactionUtils.parseJson(initialResponse);
                MainActivity.this.runOnUiThread(() -> {
                    listOfTransactions = TransactionUtils.getAllTransactionsList();
                    Log.d(TAG, listOfTransactions.toString());
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    transactionAdapter = new TransactionAdapter(MainActivity.this, listOfTransactions);
                    recyclerView.setAdapter(transactionAdapter);
                    transactionAdapter.setOnItemClicked(MainActivity.this);
                });
            }
        });
    }


    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(MainActivity.this, DetailedTransactionActivity.class);
        Transaction transaction = listOfTransactions.get(position);
        intent.putExtra("id", String.valueOf(transaction.getId()));
        intent.putExtra("amount", String.valueOf(transaction.getAmount()));
        intent.putExtra("description", transaction.getDescription());
        intent.putExtra("date", transaction.getDate());
        intent.putExtra("url", transaction.getImageUrl());
        intent.putExtra("isCredit", transaction.getIsCredit());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.sort_amount_button){
            listOfTransactions.sort(Transaction.transactionAmountComparator);
            transactionAdapter.notifyDataSetChanged();
        }
        if(id == R.id.sort_date_button){
            listOfTransactions.sort(Transaction.transactionDateComparator);
            transactionAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}