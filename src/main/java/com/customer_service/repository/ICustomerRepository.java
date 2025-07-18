package com.customer_service.repository;

import com.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByCreateDateOrderByCreateDate(LocalDateTime createDate);
}
