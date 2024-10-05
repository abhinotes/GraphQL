package com.abhinotes.graphql.server.banking.transaction.repository;

import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}