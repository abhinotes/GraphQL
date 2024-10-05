package com.abhinotes.graphql.server.banking.auditlog.controller;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.banking.auditlog.repository.AuditLogRepository;
import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.graphql.arguments.AddInputRecords;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("auditlog")
public class AuditLogController {

    private final AuditLogRepository auditLogRepository;

    public AuditLogController(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @GetMapping("/{id}")
    private Optional<AuditLog> findAuditLogByID(@PathVariable long id) {
        return auditLogRepository.findById(id);
    }

    @GetMapping("")
    private List<AuditLog> findAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    @PostMapping("")
    private AuditLog saveAuditLog(@RequestBody AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }


}

