package com.example.kuby_api.model.orders;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.model.Wines.WineQuantity;
import com.example.kuby_api.model.users.Address;
import com.example.kuby_api.model.users.Customer;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "CustomerOrder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Address shipmentAddress;
    @OneToMany
    private List<WineQuantity> wineQuantityList;
    @OneToOne
    private Status status;
    private Date date;
}