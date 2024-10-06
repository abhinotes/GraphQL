package com.abhinotes.graphql.server.graphql.service;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import com.abhinotes.graphql.server.graphql.entity.CustomerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerContextService {

    public CustomerContext findCustomerContextForGivenCustomerID(String customerID) {
        // TODO Implement Logic
        return null;
    }

    public AuditLog saveAuditLogRecord(AddInputRecords.AddAuditLogInput input) {
        return null;
    }
}
