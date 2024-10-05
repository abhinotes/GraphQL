package com.abhinotes.graphql.server.graphql.arguments;

import org.springframework.stereotype.Component;

@Component
public class AddInputRecords {

    public record AddAuditLogInput(String name, String phoneNumber, String dateRegistered, String status) {}

}
