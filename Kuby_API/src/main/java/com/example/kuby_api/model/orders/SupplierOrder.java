package com.example.kuby_api.model.orders;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "SupplierOrder")
public class SupplierOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;
    private Long wineId;
    private Date date;
    private Integer wineQuantity;
}