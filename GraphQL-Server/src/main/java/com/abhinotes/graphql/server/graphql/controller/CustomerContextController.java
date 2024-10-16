package com.abhinotes.graphql.server.graphql.controller;

import com.abhinotes.graphql.server.banking.notification.model.NotificationMessage;
import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import com.abhinotes.graphql.server.cms.account.entity.Account;
import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import com.abhinotes.graphql.server.graphql.service.downstream.AccountService;
import com.abhinotes.graphql.server.graphql.service.downstream.NotificationService;
import com.abhinotes.graphql.server.graphql.service.CustomerContextService;
import com.abhinotes.graphql.server.graphql.service.downstream.CustomerService;
import com.abhinotes.graphql.server.graphql.service.downstream.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CustomerContextController {

    private final CustomerContextService customerContextService;

    public CustomerContextController(CustomerContextService customerContextService, CustomerService customerService, AccountService accountService, TransactionService transactionService, NotificationService notificationService) {
        this.customerContextService = customerContextService;
    }


    @QueryMapping
    public Customer getCustomerContext(@Argument Long id) {
        log.trace("#GPQL# 1 : Populating Customer details Customer id {} ", id);
        return customerContextService.getCustomerDetails(id);
    }

    @SchemaMapping(typeName = "CustomerContext", field = "accounts")
    public List<Account> getAccountsForCustomer(Customer customer) {
        log.trace("#GPQL# 2 : Populating Account number for given Customer id {} ", customer.getId());
        return customerContextService.getAccountsForCustomer(customer.getId());
    }

    @SchemaMapping(typeName = "Account", field = "transactions")
    public List<Transaction> getTransactionForAccount(Account account) {
        log.trace("#GPQL# 3 : Populating Transactions for given Account Number {} ", account.getAccountNumber());
        return customerContextService.getTransactionsForAccount(account.getAccountNumber());
    }

    @SchemaMapping(typeName = "CustomerContext", field = "notifications")
    public List<NotificationMessage> getNotifications(Customer customer) {
        log.trace("#GPQL# 4 : Populating Notifications for given Customer Number {} ", customer.getId());
        return customerContextService.getNotifications();
    }



}
