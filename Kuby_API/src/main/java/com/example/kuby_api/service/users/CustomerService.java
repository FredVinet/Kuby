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

    public Customer getCustomerById(long id) {
        return null;
    }

    public Customer createCustomer(Customer customer) {
        return null;
    }

    public Customer updateCustomer(long id, Customer customer) {
        return null;

        //if (!customerRepository.existsById(id)) {
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + id);
        //}
        // return customerRepository.save(customer);
    }
    
    public void deleteCustomerById(long id) {
        
    }

    // Customer address
    public List<Address> getCustomerAddresses(long id) {
        return null;
    }
    
    public Address createCustomerAddress(long id, Address address) {
        return null;
    }

    public Address updateAdresse(long id, Address address) {
        return null;
    }


    public void deleteAddressCustomer(long id) {
    }
}
