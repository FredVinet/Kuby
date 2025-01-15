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

    @GetMapping("/supplierOrder/{supplierId}")
    public ResponseEntity<SupplierOrder> getSupplierOrderById(@PathVariable int supplierId) {
        try {
            return ResponseEntity.ok(supplierOrderService.getSupplierOrderById(supplierId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/supplierOrder/ByStatus/{statusId}")
    public ResponseEntity<List<SupplierOrder>> getSupplierOrderByStatus(@PathVariable int statusId) {
        try {
            return ResponseEntity.ok(supplierOrderService.getOrdersByStatus(statusId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supplierOrder/{supplierId}")
    public ResponseEntity<SupplierOrder> createSupplierOrder(@PathVariable int supplierId, @RequestBody SupplierOrder supplierOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierOrderService.createSupplierOrder(supplierId, supplierOrder));
    }

    @PutMapping("/supplierOrder/{supplierOrderId}")
    public ResponseEntity<SupplierOrder> updateSupplierOrder(@PathVariable int supplierOrderId, @RequestBody SupplierOrder supplierOrder) {
        if (supplierOrder.getId() != supplierOrderId) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(supplierOrderService.updateSupplierOrder(supplierOrderId, supplierOrder));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplierOrder/{isupplierOrderIdd}")
    public ResponseEntity<Void> deleteSupplierOrder(@PathVariable int supplierOrderId) {
        try {
            supplierOrderService.deleteSupplierOrder(supplierOrderId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
