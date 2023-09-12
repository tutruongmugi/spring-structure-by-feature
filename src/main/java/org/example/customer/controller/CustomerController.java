package org.example.customer.controller;

import lombok.RequiredArgsConstructor;
import org.example.customer.dto.outgoing.CustomerDto;
import org.example.customer.service.CustomerService;
import org.example.share.response.ResponseStatus;
import org.example.share.response.ResponseWithBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<ResponseWithBody<List<CustomerDto>>> getAllCustomer(){

        ResponseStatus responseStatus = ResponseStatus.builder()
                .code(0)
                .message("Success")
                .build();

        List<CustomerDto> customerDtos = customerService.findAllCustomer();

        ResponseWithBody<List<CustomerDto>> response = new ResponseWithBody<>();
        response.setBody(customerDtos);
        response.setStatus(responseStatus);

        return ResponseEntity.ok()
                .body(response);
    }
}
