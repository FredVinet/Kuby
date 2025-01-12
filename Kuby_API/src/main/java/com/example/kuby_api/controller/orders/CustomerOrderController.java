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

    @GetMapping("/customerOrders/byCustomer/{id}")
    public ResponseEntity<List<CustomerOrder>>GetAllOrdersByCustomer(@PathVariable int id) {
        try{
            return ResponseEntity.ok(customerOrderService.GetAllOrdersByCustomer());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customerOrders/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrderById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(customerOrderService.GetOrdersByCustomer());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customerOrder/ByStatus{id}")
    public ResponseEntity<List<CustomerOrder>> getCustomerOrderByStatus(@PathVariable int id) {
        try {
            return ResponseEntity.ok(customerOrderService.GetOrderByStatus(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customerOrder/{id}")
    public ResponseEntity<CustomerOrder> createCustomerOrder(@PathVariable int id, @RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrderService.createCustomerOrder(id,customerOrder));
    }

    @PutMapping("/customerOrder/{id}")
    public ResponseEntity<CustomerOrder> updateCustomerOrder(@PathVariable int id, @RequestBody CustomerOrder customerOrder) {
        if(customerOrder.getId() != id){
            return ResponseEntity.badRequest().build();
        }

        try{
            return ResponseEntity.ok(customerOrderService.updateCustomerOrder(id, customerOrder));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customerOrder/{id}")
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable int id) {
        try{
            customerOrderService.deleteCustomerOrder(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
