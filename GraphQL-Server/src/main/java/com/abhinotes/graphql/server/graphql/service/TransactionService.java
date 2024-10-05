package com.abhinotes.graphql.server.graphql.service;

import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {

    public Transaction findTransactions(String accountID) {
        // TODO Implement Logic
        return null;
    }
}
