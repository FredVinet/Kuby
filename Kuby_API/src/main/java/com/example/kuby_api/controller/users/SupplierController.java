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

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) {
        try {
            return ResponseEntity.ok(supplierService.getSupplierById(supplierId));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplier(supplier));
    }

    @PutMapping("/supplier/{supplierId}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable int supplierId, @RequestBody Supplier supplier) {
        if (supplier.getId() != supplierId) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(supplierService.updateSupplier(supplierId, supplier));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplier/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) {
        try {
            supplierService.deleteSupplierById(supplierId);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supplier address
    @GetMapping("/supplier/addresses/{supplierId}")
    public ResponseEntity<List<Address>> getSupplierAddresses(@PathVariable int supplierId) {
        try {
            return ResponseEntity.ok(supplierService.getSupplierAddresses(supplierId));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supplier/addresses/{supplierId}")
    public ResponseEntity<Address> createSupplierAddress(
            @PathVariable int supplierId,
            @RequestBody Address address
    ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplierAddress(supplierId, address));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/supplier/addresses/{supplierAddressId}")
    public ResponseEntity<Address> updateSupplierAddress(@PathVariable int supplierAddressId, @RequestBody Address address) {
        if (address.getId() != supplierAddressId) {
            return ResponseEntity.notFound().build();
        }

        try {
            return ResponseEntity.ok(supplierService.updateAddress(supplierAddressId, address));
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplier/addresses/{supplierAddressId}")
    public ResponseEntity<Void> deleteSupplierAddress(@PathVariable int supplierAddressId) {
        try {
            supplierService.deleteAddressSupplier(supplierAddressId);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
