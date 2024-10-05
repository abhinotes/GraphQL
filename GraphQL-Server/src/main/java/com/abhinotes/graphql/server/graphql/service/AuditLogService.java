package com.abhinotes.graphql.server.graphql.service;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuditLogService {

    public AuditLog saveAuditLogRecord(AddInputRecords.AddAuditLogInput addAuditLogInput) {
        // TODO Implement Logic
        return null;
    }


}
