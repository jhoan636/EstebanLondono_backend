package com.customer_service.service;

import com.customer_service.dto.CustomerDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ICustomerService {
    CustomerDto createClient(CustomerDto customer);

    CustomerDto getCustomerById(Long id);

    List<CustomerDto> findAllCustomersDateAfter(LocalDateTime date);
}
