package com.abhinotes.graphql.server.cms.customer.repository;

import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}