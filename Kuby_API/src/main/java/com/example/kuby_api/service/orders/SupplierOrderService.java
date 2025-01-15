package com.example.kuby_api.service.orders;

import com.example.kuby_api.model.orders.SupplierOrder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class SupplierOrderService {
    public List<SupplierOrder> getAllOrdersBySupplier(long supplierId) {
        return null;
    }

    public SupplierOrder getSupplierOrderById(long id) {
        return null;
    }

    public List<SupplierOrder> getOrdersByStatus(long id) {
        return null;
    }

    public SupplierOrder createSupplierOrder(long supplierId, SupplierOrder supplierOrder) {
        return null;
    }

    public SupplierOrder updateSupplierOrder(long id, SupplierOrder supplierOrder) {
        return null;
    }

    public void deleteSupplierOrder(long id) {

    }
}
