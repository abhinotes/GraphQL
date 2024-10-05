package com.abhinotes.graphql.server.m2datasource.controller;

import com.abhinotes.graphql.server.m2datasource.entity.Customer;
import com.abhinotes.graphql.server.m2datasource.repository.CustomerRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }

    @QueryMapping
    public Optional<Customer> customerById(@Argument Long id) {
        return customerRepository.findById(id);
    }

    @MutationMapping
    public Customer addCustomer(@Argument AddCustomerInput input) {
        Customer customer = new Customer(input.name(), input.phoneNumber(), input.dateRegistered(), input.status());
        return customerRepository.save(customer);
    }

    // Define the AddBookInput record
    public record AddCustomerInput(String name, String phoneNumber, String dateRegistered, String status) {}
}