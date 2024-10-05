package com.abhinotes.graphql.server.banking.auditlog.repository;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}