package com.abhinotes.graphql.server.graphql.service.impl;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import com.abhinotes.graphql.server.graphql.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuditLogService implements DataService<AuditLog> {

    @Override
    public AuditLog create(AuditLog auditLog) {
        return null;
    }


    @Override
    public AuditLog getByID(String  id) {
        return null;
    }
}
