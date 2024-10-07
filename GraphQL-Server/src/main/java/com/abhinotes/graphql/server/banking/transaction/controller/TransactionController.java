package com.abhinotes.graphql.server.banking.transaction.controller;

import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import com.abhinotes.graphql.server.banking.transaction.repository.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{id}")
    private Optional<Transaction> findTransactionbyID(@PathVariable long id) {
        return transactionRepository.findById(id);
    }

    @GetMapping("/account/{accountNumber}")
    private Optional<List<Transaction>> findTransactionByAccountNumber(@PathVariable String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    @PostMapping("")
    private Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}

