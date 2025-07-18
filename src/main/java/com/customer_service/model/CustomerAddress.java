package com.customer_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "CustomerAddress")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customerId;
    @Column(name = "street")
    @NotBlank
    private String street;
    @Column(name = "city")
    @NotBlank
    private String city;
    @Column(name = "state")
    @NotBlank
    private String state;
    @Column(name = "postal_code")
    @NotBlank
    private String postalCode;
    @Column(name = "country")
    @NotBlank
    private String country;

}
