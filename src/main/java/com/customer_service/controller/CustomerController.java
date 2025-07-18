package com.customer_service.controller;

import com.customer_service.dto.CustomerDto;
import com.customer_service.model.Customer;
import com.customer_service.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer", description = "API para la gestión de clientes")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(
            summary = "Crear clientes",
            description = "Devuelve el detalle del cliente creado."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Cliente creado",
            content = @Content(schema = @Schema(implementation = Customer.class))
    )
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    @PostMapping
    public ResponseEntity<CustomerDto> createClient(@Valid @RequestBody CustomerDto customer) {
        CustomerDto response = customerService.createClient(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto response = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/dateAfter/{date}")
    public ResponseEntity<List<CustomerDto>> findAllCustomersDateAfter(@PathVariable("date") LocalDateTime date) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAllCustomersDateAfter(date));
    }
}
