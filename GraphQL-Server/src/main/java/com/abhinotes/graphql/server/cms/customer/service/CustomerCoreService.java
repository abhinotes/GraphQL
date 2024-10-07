package com.abhinotes.graphql.server.cms.customer.service;

import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.cms.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerCoreService {

    private final CustomerRepository customerRepository;

    public CustomerCoreService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
