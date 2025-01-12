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

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("pouet");
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

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        if (customer.getId() != id) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(customerService.updateCustomer(id, customer));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        try {
           customerService.deleteCustomerById(id);
           return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Customer address
    @GetMapping("/customer/addresses/{id}")
    public ResponseEntity<List<Address>> getCustomerAddresses(@PathVariable int id) {
        try {
            return ResponseEntity.ok(customerService.getCustomerAddresses(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customer/addresses/{id}")
    public ResponseEntity<Address> createCustomerAddress(
            @PathVariable int id,
            @RequestBody Address address
    ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomerAddress(id, address));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/customer/addresses/{id}")
    public ResponseEntity<Address> updateCustomerAddress(@PathVariable int id, @RequestBody Address address) {
        if (address.getId() != id){
            return ResponseEntity.notFound().build();
        }

        try {
            return ResponseEntity.ok(customerService.updateAdresse(id, address));
        }catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customer/addresses/{id}")
    public ResponseEntity<Void> deleteCustomerAddress(@PathVariable int id) {
        try {
            customerService.deleteAddressCustomer(id);
            return ResponseEntity.ok().build();
        }catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
