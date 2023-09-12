package org.example.customer.service;

import org.example.customer.dto.outgoing.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAllCustomer();
}
