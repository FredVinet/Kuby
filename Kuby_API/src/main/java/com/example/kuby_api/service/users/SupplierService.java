package com.example.kuby_api.service.users;

import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Supplier;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class SupplierService {
    public List<Supplier> getAllSuppliers() {
        return null;
    }

    public Supplier getSupplierById(int id) {
        return null;
    }

    public Supplier createSupplier(Supplier supplier) {
        return null;
    }

    public Supplier updateSupplier(int id, Supplier supplier) {
        return null;
    }

    public void deleteSupplierById(int id) {
    }

    public List<Address> getSupplierAddresses(int id) {
        return null;
    }

    public Address createSupplierAddress(int id, Address address) {
        return null;
    }

    public Address updateAddress(int id, Address address) {
        return null;
    }

    public void deleteAddressSupplier(int id) {

    }
}
