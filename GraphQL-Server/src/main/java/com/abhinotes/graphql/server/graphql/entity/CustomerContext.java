package com.abhinotes.graphql.server.graphql.entity;

import com.abhinotes.graphql.server.banking.auditlog.entity.AuditLog;
import com.abhinotes.graphql.server.cms.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerContext {

    private Long id;
    private String name;
    private String phoneNumber;
    private String dateRegistered;
    private String status;
    private List<Account> accounts;
    private List<AuditLog> auditLogs;

}
