package com.abhinotes.graphql.server.graphql.service.impl;

import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.cms.customer.service.CustomerCoreService;
import com.abhinotes.graphql.server.graphql.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerService implements DataService<Optional<Customer>> {

    private final CustomerCoreService customerCoreService;

    public CustomerService(CustomerCoreService customerCoreService) {
        this.customerCoreService = customerCoreService;
    }

    @Override
    public Optional<Customer> create(Optional<Customer> customer) {
        return Optional.ofNullable(customerCoreService.addCustomer(customer.orElse(null)));
    }

    @Override
    public Optional<Customer> getByID(String customerId) {
        Optional<Customer> customer = Optional.empty();
        try {
            customer =  customerCoreService.customerById(Long.parseLong(customerId));
        } catch (NumberFormatException nfe) {
            log.error("Expected Customer ID as long , where as it was provided as {} Failed with error {}", customerId, nfe.getMessage(),  nfe);
        }
        return customer;
    }
}
