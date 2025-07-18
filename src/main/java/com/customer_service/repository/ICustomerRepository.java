package com.customer_service.repository;

import com.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository <Customer, Long>{
}
