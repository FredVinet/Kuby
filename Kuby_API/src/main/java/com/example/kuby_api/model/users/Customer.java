package com.example.kuby_api.model.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private Long id;
    @Setter
    private String name;

    public void setId(long id) {
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }
}
