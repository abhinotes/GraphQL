package com.abhinotes.graphql.server.graphql.controller;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import com.abhinotes.graphql.server.graphql.entity.CustomerContext;
import com.abhinotes.graphql.server.graphql.service.AccountService;
import com.abhinotes.graphql.server.graphql.service.AuditLogService;
import com.abhinotes.graphql.server.graphql.service.CustomerContextService;
import com.abhinotes.graphql.server.graphql.service.CustomerService;
import com.abhinotes.graphql.server.graphql.service.TransactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerContextController {

    private final CustomerContextService customerContextService;
    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final AuditLogService auditLogService;

    public CustomerContextController(CustomerContextService customerContextService, CustomerService customerService, AccountService accountService, TransactionService transactionService, AuditLogService auditLogService) {
        this.customerContextService = customerContextService;
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.auditLogService = auditLogService;
    }


    @QueryMapping
    public CustomerContext getCustomerContext(@Argument String id) {
        return customerContextService.findCustomerContextForGivenCustomerID(id);
    }

    @MutationMapping
    public AuditLog addAuditLog(@Argument AddInputRecords.AddAuditLogInput input) {
        return auditLogService.saveAuditLogRecord(input);
    }


}
