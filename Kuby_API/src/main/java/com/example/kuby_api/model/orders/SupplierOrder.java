package com.example.kuby_api.model.orders;

import com.example.kuby_api.model.Wines.WineQuantity;
import com.example.kuby_api.model.users.Supplier;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "SupplierOrder")
public class SupplierOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Supplier supplier;
    @OneToMany
    private List<WineQuantity> wineQuantityList;
    private Date date;

}