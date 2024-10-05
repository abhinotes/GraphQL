package com.abhinotes.graphql.server.cms.account.controller;

import com.abhinotes.graphql.server.cms.account.entity.Account;
import com.abhinotes.graphql.server.cms.account.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/{id}")
    private Optional<Account> findAccountByID(@PathVariable long id) {
        return accountRepository.findById(id);
    }

    @GetMapping("")
    private List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("")
    private Account saveAccont(@RequestBody Account account) {
        return accountRepository.save(account);
    }
}

