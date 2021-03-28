package com.example.transactions.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Transaction {
    @JsonProperty("id")
    private int id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("amount")
    private double amount;
    @JsonProperty("isCredit")
    private boolean isCredit;
    @JsonProperty("description")
    private String description;
    @JsonProperty("imageUrl")
    private String imageUrl;
/*    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();*/

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("amount")
    public double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("isCredit")
    public boolean getIsCredit() {
        return isCredit;
    }

    @JsonProperty("isCredit")
    public void setIsCredit(boolean isCredit) {
        this.isCredit = isCredit;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //sorting in descending order
    public static Comparator<Transaction> transactionAmountComparator = (o1, o2) -> {
        double amount1 = o1.getAmount();
        double amount2 = o2.getAmount();
        return (int) (amount2 - amount1);
    };

    public static Comparator<Transaction> transactionDateComparator = (o1, o2) -> {
        String date1 = o1.getDate();
        String date2 = o2.getDate();
        return date2.compareTo(date1);
    };

/*    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }*/
}
