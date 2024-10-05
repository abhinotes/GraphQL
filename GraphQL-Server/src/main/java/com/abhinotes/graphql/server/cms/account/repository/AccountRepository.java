package com.abhinotes.graphql.server.cms.account.repository;

import com.abhinotes.graphql.server.cms.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}