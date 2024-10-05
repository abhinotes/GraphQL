package com.abhinotes.graphql.server.banking.auditlog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue
    private Long id;

    private String source;
    private String timestamp;
    private String action;
    private String auditDetails;

    public AuditLog() {
    }

    public AuditLog(String source, String timestamp, String action, String auditDetails) {
        this.source = source;
        this.timestamp = timestamp;
        this.action = action;
        this.auditDetails = auditDetails;
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAuditDetails() {
        return auditDetails;
    }

    public void setAuditDetails(String auditDetails) {
        this.auditDetails = auditDetails;
    }
}
