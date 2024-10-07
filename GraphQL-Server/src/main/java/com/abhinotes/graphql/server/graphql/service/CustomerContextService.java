package com.abhinotes.graphql.server.graphql.service;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import com.abhinotes.graphql.server.cms.account.entity.Account;
import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import com.abhinotes.graphql.server.graphql.service.downstream.AccountService;
import com.abhinotes.graphql.server.graphql.service.downstream.AuditLogService;
import com.abhinotes.graphql.server.graphql.service.downstream.CustomerService;
import com.abhinotes.graphql.server.graphql.service.downstream.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerContextService {

    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final AuditLogService auditLogService;

    public CustomerContextService(CustomerService customerService, AccountService accountService, TransactionService transactionService, AuditLogService auditLogService) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.auditLogService = auditLogService;
    }


    public Customer getCustomerDetails(Long customerID) {
        Optional<Customer> customer = customerService.findCustomerByID(customerID);
        if(customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    public List<Account> getAccountsForCustomer(Long customerID) {
        return accountService.getByCustomerID(customerID);
    }

    public List<Transaction> getTransactionsForAccount(String accountID) {
        List<Transaction> transactionList = transactionService.getByAccountNumber(accountID);
        log.trace(transactionList.toString());
        return transactionList;
    }

    public AuditLog saveAuditLogRecord(AddInputRecords.AddAuditLogInput input) {
        return null;
    }
}
