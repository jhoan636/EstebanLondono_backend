package com.customer_service.controller;

import com.customer_service.dto.CustomerDto;
import com.customer_service.model.Customer;
import com.customer_service.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createClient(@Valid @RequestBody CustomerDto customer ) {
        CustomerDto response=  customerService.createClient(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
