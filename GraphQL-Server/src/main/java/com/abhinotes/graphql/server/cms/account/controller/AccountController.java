package com.abhinotes.graphql.server.cms.account.controller;

import com.abhinotes.graphql.server.cms.account.entity.Account;
import com.abhinotes.graphql.server.cms.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/{id}")
    private Optional<Account> findAccountByID(@PathVariable long id) {
        log.trace("In class {} , method {} called for Account ID {} !!"
                , this.getClass().getName(), "findAccountByID",id);
        return accountRepository.findById(id);
    }


    @GetMapping("/customer/{id}")
    private Optional<List<Account>> findAccountByCustomerID(@PathVariable long id) {
        log.trace("In class {} , method {} called for Customer ID {}!!",
                this.getClass().getName(), "findAccountByCustomerID",id);
        return accountRepository.findByCustomerID(id);
    }

    @GetMapping("")
    private List<Account> findAllAccounts() {
        log.trace("In class {} , method {} called !!", this.getClass().getName(), "findAllAccounts");
        return accountRepository.findAll();
    }

    @PostMapping("")
    private Account saveAccont(@RequestBody Account account) {
        log.trace("In class {} , method {} called with value {} !!",
                this.getClass().getName(), "saveAccount",account.toString() );
        return accountRepository.save(account);
    }
}

