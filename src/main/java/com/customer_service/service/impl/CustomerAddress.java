package com.customer_service.service.impl;

import com.customer_service.dto.CustomerDto;
import com.customer_service.model.Customer;
import com.customer_service.service.ICustomerAddress;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddress implements ICustomerAddress {
    @Override
    public CustomerDto updateCustomerAdreess(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
