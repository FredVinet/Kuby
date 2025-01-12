package com.example.kuby_api.service.users;

import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Customer;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CustomerService {
    // Customer
    public List<Customer> getAllCustomers() {
        return null;
    }

    public Customer getCustomerById(int id) {
        return null;
    }

    public Customer createCustomer(Customer customer) {
        return null;
    }

    public Customer updateCustomer(int id, Customer customer) {
        return null;

        //if (!customerRepository.existsById(id)) {
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + id);
        //}
        // return customerRepository.save(customer);
    }
    
    public void deleteCustomerById(int id) {
        
    }

    // Customer address
    public List<Address> getCustomerAddresses(int id) {
        return null;
    }
    
    public Address createCustomerAddress(int id, Address address) {
        return null;
    }

    public Address updateAdresse(int id, Address address) {
        return null;
    }


    public void deleteAddressCustomer(int id) {
    }
}
