package com.customer_service.service;

import com.customer_service.dto.CustomerDto;
import com.customer_service.model.Customer;

public interface ICustomerAddress {
    CustomerDto updateCustomerAdreess(Customer customer);
    void deleteCustomer(Long id);
}
