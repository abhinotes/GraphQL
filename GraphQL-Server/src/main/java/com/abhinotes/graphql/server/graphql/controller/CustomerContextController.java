package com.abhinotes.graphql.server.graphql.controller;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import com.abhinotes.graphql.server.graphql.entity.CustomerContext;
import com.abhinotes.graphql.server.graphql.service.downstream.AccountService;
import com.abhinotes.graphql.server.graphql.service.downstream.AuditLogService;
import com.abhinotes.graphql.server.graphql.service.CustomerContextService;
import com.abhinotes.graphql.server.graphql.service.downstream.CustomerService;
import com.abhinotes.graphql.server.graphql.service.downstream.TransactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerContextController {

    private final CustomerContextService customerContextService;

    public CustomerContextController(CustomerContextService customerContextService, CustomerService customerService, AccountService accountService, TransactionService transactionService, AuditLogService auditLogService) {
        this.customerContextService = customerContextService;
    }


    @QueryMapping
    public CustomerContext getCustomerContext(@Argument Long id) {
        return customerContextService.findCustomerContextForGivenCustomerID(id);
    }

    @MutationMapping
    public AuditLog addAuditLog(@Argument AddInputRecords.AddAuditLogInput input) {
        return customerContextService.saveAuditLogRecord(input);
    }


}
