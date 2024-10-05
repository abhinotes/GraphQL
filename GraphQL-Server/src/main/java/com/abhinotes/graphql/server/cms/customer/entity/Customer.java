package com.abhinotes.graphql.server.cms.customer.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;
    private String dateRegistered;
    private String status;

    // Constructors, getters, and setters
    public Customer() {}

    public Customer(String name, String phoneNumber, String dateRegistered, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateRegistered = dateRegistered;
        this.status = status;
    }

    // Getters and setters...
}