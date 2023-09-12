package org.example.customer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.customer.dto.outgoing.CustomerDto;
import org.example.customer.entity.Customer;
import org.example.customer.mapper.CustomerMapper;
import org.example.customer.repository.CustomerRepository;
import org.example.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> findAllCustomer() {
        log.info("Execute business logic find all customer");
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> customerMapper.toDto(customer)).collect(Collectors.toList());
    }
}
