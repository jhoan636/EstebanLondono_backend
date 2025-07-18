package com.customer_service.service;

import com.customer_service.dto.CustomerDto;
import com.customer_service.model.Customer;

import java.util.List;

public interface ICustomerService {
    CustomerDto createClient(CustomerDto customer);
    CustomerDto getCustomerById(Long id);
    CustomerDto updateCustomerAdreess(Customer customer);
    void deleteCustomer(Long id);
    List<CustomerDto> findAllCustomersDateAfter();
}
