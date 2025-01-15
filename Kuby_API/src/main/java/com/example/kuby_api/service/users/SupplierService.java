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

    public Supplier getSupplierById(long id) {
        return null;
    }

    public Supplier createSupplier(Supplier supplier) {
        return null;
    }

    public Supplier updateSupplier(long id, Supplier supplier) {
        return null;
    }

    public void deleteSupplierById(long id) {
    }

    public List<Address> getSupplierAddresses(long id) {
        return null;
    }

    public Address createSupplierAddress(long id, Address address) {
        return null;
    }

    public Address updateAddress(long id, Address address) {
        return null;
    }

    public void deleteAddressSupplier(long id) {

    }
}
