package com.abhinotes.graphql.server.banking.transaction.repository;

import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<List<Transaction>> findByAccountNumber(String accountNumber);

}

