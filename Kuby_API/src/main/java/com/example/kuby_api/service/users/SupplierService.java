package com.example.kuby_api.service.users;

import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Supplier;
import com.example.kuby_api.repository.users.IAddressRepository;
import com.example.kuby_api.repository.users.ISupplierRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
public class SupplierService {
    @Autowired
    ISupplierRepository supplierRepository;
    @Autowired
    private IAddressRepository addressRepository;

    //Supplier
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(long supplierId, Supplier supplier) {
        if(!supplierRepository.existsById(supplierId)) {
            throw new NoSuchElementException("Supplier not found");
        }
        return supplierRepository.save(supplier);
    }

    public void deleteSupplierById(long supplierId) {
        if(!supplierRepository.existsById(supplierId)) {
            throw new NoSuchElementException("Supplier not found");
        }
        supplierRepository.deleteById(supplierId);
    }

    // Supplier address
    public Address getSupplierAddress(long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new NoSuchElementException("Supplier not found"));
        return supplier.getAddress();
    }

    public Address createSupplierAddress(long supplierId, Address address) {
        if(!supplierRepository.existsById(supplierId)) {
            throw new NoSuchElementException("Supplier not found");
        }

        Supplier supplier = supplierRepository.findById(supplierId).get();
        Address newAddress = addressRepository.save(address);
        supplier.setAddress(newAddress);
        supplierRepository.save(supplier);
        return newAddress;
    }

    public Address updateAddress(Address address) {
        if(!addressRepository.existsById(address.getId())) {
            throw new NoSuchElementException("Supplier not found");
        }
            return addressRepository.save(address);
    }

    public void deleteAddressSupplier(long id) {
        if(!addressRepository.existsById(id)) {
            throw new NoSuchElementException("Supplier not found");
        }
        addressRepository.deleteById(id);
    }



}
