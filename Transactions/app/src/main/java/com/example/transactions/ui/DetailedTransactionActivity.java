package com.example.transactions.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.transactions.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailedTransactionActivity extends AppCompatActivity {
    public static final String TAG = DetailedTransactionActivity.class.getSimpleName();

    private TextView amountTextView, descriptionTextView, dateTextView;
    private Button saveButton;
    private boolean isCredit;
    private String url;
    private ImageView checkImage;
    private EditText noteET;
    SharedPreferences notePreferences;
    private String savedNote;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_transaction);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Transaction Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        amountTextView = findViewById(R.id.amount_detail_tv);
        descriptionTextView = findViewById(R.id.description_detail_tv);
        dateTextView = findViewById(R.id.date_detail_tv);
        checkImage = findViewById(R.id.check_img);
        noteET = findViewById(R.id.notes_et);
        saveButton = findViewById(R.id.save_note_btn);
        saveButton.setOnClickListener(v -> saveNote());

        Intent data = getIntent();
        if (data != null) {
            amountTextView.setText(String.format("$ %s", data.getStringExtra("amount")));
            descriptionTextView.setText(data.getStringExtra("description"));
            dateTextView.setText(data.getStringExtra("date"));
            isCredit = data.getBooleanExtra("isCredit", false);
            url = data.getStringExtra("url");
            id = data.getStringExtra("id");
        }

        if (isCredit) {
            amountTextView.setVisibility(View.GONE);
            descriptionTextView.setVisibility(View.GONE);
            dateTextView.setVisibility(View.GONE);
            noteET.setVisibility(View.GONE);
            saveButton.setVisibility(View.GONE);

            if(url != null){
                try {
                    displayImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else{
            savedNote = "com.example.transactions." + id;
            notePreferences = getSharedPreferences(savedNote, MODE_PRIVATE);
            String note = notePreferences.getString("note", "");
            noteET.setText(note);
        }

    }

    private void displayImage() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final Bitmap bitmap = BitmapFactory.decodeStream(Objects.requireNonNull(response.body()).byteStream());
                DetailedTransactionActivity.this.runOnUiThread(() -> {
                    checkImage.setImageBitmap(bitmap);
                    checkImage.setVisibility(View.VISIBLE);
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: saving current notes");
        //save note if user exits activity prematurely
        if(!isCredit){
            SharedPreferences.Editor saveNotesEditor = notePreferences.edit();
            saveNotesEditor.putString("note", noteET.getText().toString());
            saveNotesEditor.apply();
        }

    }

    private void saveNote(){
        SharedPreferences.Editor saveNotesEditor = notePreferences.edit();
        saveNotesEditor.putString("note", noteET.getText().toString());
        saveNotesEditor.apply();
        Toast.makeText(this, "Note saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}