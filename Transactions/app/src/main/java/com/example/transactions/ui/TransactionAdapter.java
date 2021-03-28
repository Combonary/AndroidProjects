package com.example.transactions.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transactions.R;
import com.example.transactions.model.Transaction;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>{

    ArrayList<Transaction> transactionArrayList;
    Context context;
    private OnTransactionSelected itemClicked;

    public interface OnTransactionSelected{
        void onItemClicked(int position);
    }

    public TransactionAdapter(Context context, ArrayList<Transaction> arr) {
        transactionArrayList = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactionArrayList.get(position);
        holder.amountTextView.setText(String.format("$ %s", transaction.getAmount()));
        holder.descriptionTextView.setText(transaction.getDescription());
        holder.dateTextView.setText(transaction.getDate().substring(0, 10));
        if(transaction.getIsCredit()){
            holder.itemLayout.setBackgroundColor(Color.parseColor("#fbe8e8"));
        }else{
            holder.itemLayout.setBackgroundColor(Color.parseColor("#d2f8d2"));
        }

        holder.itemLayout.setOnClickListener(v -> itemClicked.onItemClicked(position));
    }

    @Override
    public int getItemCount() {
        return transactionArrayList.size();
    }

    public void setOnItemClicked(OnTransactionSelected itemClicked){
        this.itemClicked = itemClicked;
    }

    static class TransactionViewHolder extends RecyclerView.ViewHolder{
        TextView amountTextView, descriptionTextView, dateTextView;
        RelativeLayout itemLayout;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            amountTextView = itemView.findViewById(R.id.amount_tv);
            descriptionTextView = itemView.findViewById(R.id.description_tv);
            dateTextView = itemView.findViewById(R.id.date_tv);
            itemLayout = itemView.findViewById(R.id.item_background);
        }
    }
}
