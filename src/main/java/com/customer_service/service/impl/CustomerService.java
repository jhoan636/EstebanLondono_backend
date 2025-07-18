package com.customer_service.service.impl;

import com.customer_service.dto.CustomerDto;
import com.customer_service.model.Customer;
import com.customer_service.repository.ICustomerRepository;
import com.customer_service.service.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createClient(CustomerDto customer) {
        customer.setCreateDate(LocalDateTime.now());
        Customer entity = new Customer();
        entity.setCreateDate(customer.getCreateDate());
        entity.setEmail(customer.getEmail());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setLastUpdate(customer.getLastUpdate());
        Customer client = customerRepository.save(entity);
        System.out.println(customerRepository.findAll());
        return toDobject(client);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        return toDobject(customer);
    }


    @Override
    public List<CustomerDto> findAllCustomersDateAfter(LocalDateTime date) {
        List<Customer> customers = customerRepository.findByCreateDateOrderByCreateDate(date);
        List<CustomerDto> dtos = new ArrayList<>();
        for (Customer customer : customers) {
            dtos.add(toDobject(customer));
        }
        return dtos;
    }

    private CustomerDto toDobject(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setCreateDate(customer.getCreateDate());
        dto.setEmail(customer.getEmail());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setLastUpdate(customer.getLastUpdate());
        return dto;
    }
}
