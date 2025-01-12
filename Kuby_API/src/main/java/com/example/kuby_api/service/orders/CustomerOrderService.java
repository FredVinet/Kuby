package com.example.kuby_api.service.orders;

import com.example.kuby_api.model.orders.CustomerOrder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CustomerOrderService {
    public List<CustomerOrder> GetAllOrdersByCustomer() {
        return null;
    }

    public CustomerOrder GetOrdersByCustomer() {
        return null;
    }

    public List<CustomerOrder> GetOrderByStatus(int id) {
        return null;
    }

    public CustomerOrder createCustomerOrder(int id, CustomerOrder customerOrder) {
        return null;
    }

    public CustomerOrder updateCustomerOrder(int id, CustomerOrder customerOrder) {
        return null;
    }

    public void deleteCustomerOrder(int id) {
    }
}
