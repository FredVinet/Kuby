package com.example.kuby_api.controller.orders;

import com.example.kuby_api.model.orders.SupplierOrder;
import com.example.kuby_api.service.orders.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierOrderController {
    @Autowired
    private SupplierOrderService supplierOrderService;

    @GetMapping("/supplierOrder/bySupplier/{supplierId}")
    public ResponseEntity<List<SupplierOrder>> getAllOrdersBySupplier(@PathVariable int supplierId) {
        try {
            return ResponseEntity.ok(supplierOrderService.getAllOrdersBySupplier(supplierId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/supplierOrder/{id}")
    public ResponseEntity<SupplierOrder> getSupplierOrderById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(supplierOrderService.getSupplierOrderById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/supplierOrder/ByStatus/{statusId}")
    public ResponseEntity<List<SupplierOrder>> getSupplierOrderByStatus(@PathVariable int id) {
        try {
            return ResponseEntity.ok(supplierOrderService.getOrdersByStatus(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supplierOrder")
    public ResponseEntity<SupplierOrder> createSupplierOrder(@RequestBody SupplierOrder supplierOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierOrderService.createSupplierOrder(supplierOrder));
    }

    @PutMapping("/supplierOrder/{id}")
    public ResponseEntity<SupplierOrder> updateSupplierOrder(@PathVariable int id, @RequestBody SupplierOrder supplierOrder) {
        if (supplierOrder.getId() != id) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(supplierOrderService.updateSupplierOrder(id, supplierOrder));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplierOrder/{id}")
    public ResponseEntity<Void> deleteSupplierOrder(@PathVariable int id) {
        try {
            supplierOrderService.deleteSupplierOrder(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
