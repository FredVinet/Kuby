package com.example.kuby_api.controller.orders;

import com.example.kuby_api.model.orders.CustomerOrder;
import com.example.kuby_api.service.orders.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/customerOrders/byCustomer/{customerId}")
    public ResponseEntity<List<CustomerOrder>>GetAllOrdersByCustomer(@PathVariable int customerId) {
        try{
            return ResponseEntity.ok(customerOrderService.GetAllOrdersByCustomer());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customerOrders/{customerId}")
    public ResponseEntity<CustomerOrder> getCustomerOrderById(@PathVariable int customerId) {
        try {
            return ResponseEntity.ok(customerOrderService.GetOrdersByCustomer());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customerOrder/ByStatus{statusId}")
    public ResponseEntity<List<CustomerOrder>> getCustomerOrderByStatus(@PathVariable int statusId) {
        try {
            return ResponseEntity.ok(customerOrderService.GetOrderByStatus(statusId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customerOrder/{customerId}")
    public ResponseEntity<CustomerOrder> createCustomerOrder(@PathVariable int customerId, @RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrderService.createCustomerOrder(customerId,customerOrder));
    }

    @PutMapping("/customerOrder/{customerOrderId}")
    public ResponseEntity<CustomerOrder> updateCustomerOrder(@PathVariable int customerOrderId, @RequestBody CustomerOrder customerOrder) {
        if(customerOrder.getId() != customerOrderId){
            return ResponseEntity.badRequest().build();
        }

        try{
            return ResponseEntity.ok(customerOrderService.updateCustomerOrder(customerOrderId, customerOrder));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customerOrder/{customerOrderId}")
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable int customerOrderId) {
        try{
            customerOrderService.deleteCustomerOrder(customerOrderId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
