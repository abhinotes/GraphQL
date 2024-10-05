package com.abhinotes.graphql.server.m2datasource.repository;

import com.abhinotes.graphql.server.m2datasource.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}