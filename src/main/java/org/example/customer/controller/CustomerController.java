package org.example.customer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.customer.dto.outgoing.CustomerDto;
import org.example.customer.service.CustomerService;
import org.example.share.response.ResponseStatus;
import org.example.share.response.ResponseWithBody;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.example.share.Constants.TRACE_ID;

@RestController
@RequestMapping(value = "/api/v1/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<ResponseWithBody<List<CustomerDto>>> getAllCustomer(){
        UUID uuid = UUID.randomUUID();
        MDC.put(TRACE_ID, uuid.toString());

        log.info("Start get all customer");
        ResponseStatus responseStatus = ResponseStatus.builder()
                .code(0)
                .message("Success")
                .build();

        List<CustomerDto> customerDtos = customerService.findAllCustomer();

        ResponseWithBody<List<CustomerDto>> response = new ResponseWithBody<>();
        response.setBody(customerDtos);
        response.setStatus(responseStatus);

        MDC.clear();
        return ResponseEntity.ok()
                .body(response);
    }
}
