package com.example.kuby_api.service.users;

import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Customer;
import com.example.kuby_api.repository.users.IAddressRepository;
import com.example.kuby_api.repository.users.ICustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
public class CustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    private IAddressRepository addressRepository;
    // Customer
    public List<Customer> getAllCustomers() { return customerRepository.findAll();}

    public Customer getCustomerById(long customerId) {
        return  customerRepository.findById(customerId)
                .orElseThrow(()-> new NoSuchElementException("Customer not found with id: " + customerId));
    }

    public Customer createCustomer(Customer customer) { return customerRepository.save(customer);}


    public Customer updateCustomer(long customerId, Customer customer) {
        if (!customerRepository.existsById(customerId)) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + customerId);
        }
         return customerRepository.save(customer);
    }
    
    public void deleteCustomerById(long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + customerId);
        }
        customerRepository.deleteById(customerId);
    }

    // Customer address
    public List<Address> getCustomerAddresses(long customerId) {
        return null; //TODO comment choper la liste d'adresse
    }
    
    public Address createCustomerAddress(long customerId, Address address) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + customerId);
        }

        Customer customer = getCustomerById(customerId);
        Address newAddress = addressRepository.save(address);
        customer.getAddressList().add(newAddress);
        customerRepository.save(customer);
        return newAddress;
    }

    public Address updateAdresse(Address address) {
        if (!customerRepository.existsById(address.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id: " + address.getId());
        }
        address.setId(address.getId());
        return addressRepository.save(address);
    }


    public void deleteAddressCustomer(long addressId) {
        if (!customerRepository.existsById(addressId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id: " + addressId);
        }
        addressRepository.deleteById(addressId);
    }
}
