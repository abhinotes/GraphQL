package com.abhinotes.graphql.server.cms.account.repository;

import com.abhinotes.graphql.server.cms.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<List<Account>> findByCustomerID(Long customerID);
}