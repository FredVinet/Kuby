package com.example.kuby_api.model.orders;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "CustomerOrder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long shipmentAddress;
    private Long wineId;
    private Date date;
    private Integer wineQuantity;
}