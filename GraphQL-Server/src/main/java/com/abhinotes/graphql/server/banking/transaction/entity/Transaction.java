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

    private String accountNumber;
    private String transactionType;
    private String dateTransacted;
    private Float amount;
    private String status;

    public Transaction() {
    }

    public Transaction(String accountNumber, String transactionType, String dateTransacted, Float amount, String status) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.dateTransacted = dateTransacted;
        this.amount = amount;
        this.status = status;
    }
}
