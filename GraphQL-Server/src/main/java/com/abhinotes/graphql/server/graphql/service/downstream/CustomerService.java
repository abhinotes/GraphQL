package com.abhinotes.graphql.server.graphql.service.downstream;

import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.cms.customer.service.CustomerCoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerService  {

    private final CustomerCoreService customerCoreService;

    public CustomerService(CustomerCoreService customerCoreService) {
        this.customerCoreService = customerCoreService;
    }

    public Optional<Customer> createCustomerRecord(Customer customer) {
        return Optional.ofNullable(customerCoreService.addCustomer(customer));
    }

    public Optional<Customer> findCustomerByID(Long customerId) {
        return customerCoreService.findCustomerById(customerId);
    }
}
