package com.example.kuby_api.controller.users;

import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Supplier;
import com.example.kuby_api.service.users.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    // Supplier
    @GetMapping("/supplier")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(supplierService.getSupplierById(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplier(supplier));
    }

    @PutMapping("/supplier/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        if (supplier.getId() != id) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int id) {
        try {
            supplierService.deleteSupplierById(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supplier address
    @GetMapping("/supplier/addresses/{id}")
    public ResponseEntity<List<Address>> getSupplierAddresses(@PathVariable int id) {
        try {
            return ResponseEntity.ok(supplierService.getSupplierAddresses(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supplier/addresses/{id}")
    public ResponseEntity<Address> createSupplierAddress(
            @PathVariable int id,
            @RequestBody Address address
    ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplierAddress(id, address));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/supplier/addresses/{id}")
    public ResponseEntity<Address> updateSupplierAddress(@PathVariable int id, @RequestBody Address address) {
        if (address.getId() != id) {
            return ResponseEntity.notFound().build();
        }

        try {
            return ResponseEntity.ok(supplierService.updateAddress(id, address));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplier/addresses/{id}")
    public ResponseEntity<Void> deleteSupplierAddress(@PathVariable int id) {
        try {
            supplierService.deleteAddressSupplier(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
