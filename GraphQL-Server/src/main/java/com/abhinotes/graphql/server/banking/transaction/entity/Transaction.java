package com.abhinotes.graphql.server.banking.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private String account;
    private String transactionType;
    private String dateTransacted;
    private Float amount;
    private String status;

    public Transaction() {
    }

    public Transaction(String account, String transactionType, String dateTransacted, Float amount, String status) {
        this.account = account;
        this.transactionType = transactionType;
        this.dateTransacted = dateTransacted;
        this.amount = amount;
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDateTransacted() {
        return dateTransacted;
    }

    public void setDateTransacted(String dateTransacted) {
        this.dateTransacted = dateTransacted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
