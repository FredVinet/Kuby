package com.example.kuby_api.controller.users;

import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Customer;
import com.example.kuby_api.service.users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Customer
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setName("pouet");
        customers.add(customer);
        return ResponseEntity.ok(customers);

        //return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("soso");
        return ResponseEntity.ok(customer);
//        try {
//            return ResponseEntity.ok(customerService.getCustomerById(id));
//        } catch (ResponseStatusException e) {
//            return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
        //return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        if (customer.getId() != customerId) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
        try {
           customerService.deleteCustomerById(customerId);
           return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Customer address
    @GetMapping("/customer/addresses/{customerId}")
    public ResponseEntity<List<Address>> getCustomerAddresses(@PathVariable int customerId) {
        try {
            return ResponseEntity.ok(customerService.getCustomerAddresses(customerId));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customer/addresses/{customerId}")
    public ResponseEntity<Address> createCustomerAddress(
            @PathVariable int customerId,
            @RequestBody Address address
    ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomerAddress(customerId, address));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/customer/addresses/{customerAddressId}")
    public ResponseEntity<Address> updateCustomerAddress(@PathVariable int customerAddressId, @RequestBody Address address) {
        if (address.getId() != customerAddressId){
            return ResponseEntity.notFound().build();
        }

        try {
            return ResponseEntity.ok(customerService.updateAdresse(customerAddressId, address));
        }catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customer/addresses/{customerAddressId}")
    public ResponseEntity<Void> deleteCustomerAddress(@PathVariable int customerAddressId) {
        try {
            customerService.deleteAddressCustomer(customerAddressId);
            return ResponseEntity.ok().build();
        }catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
