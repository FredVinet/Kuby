package com.example.kuby_api.service.orders;

import com.example.kuby_api.model.orders.SupplierOrder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class SupplierOrderService {
    public List<SupplierOrder> getAllOrdersBySupplier(int supplierId) {
        return null;
    }

    public SupplierOrder getSupplierOrderById(int id) {
        return null;
    }

    public List<SupplierOrder> getOrdersByStatus(int id) {
        return null;
    }

    public SupplierOrder createSupplierOrder(SupplierOrder supplierOrder) {
        return null;
    }

    public SupplierOrder updateSupplierOrder(int id, SupplierOrder supplierOrder) {
        return null;
    }

    public void deleteSupplierOrder(int id) {

    }
}
