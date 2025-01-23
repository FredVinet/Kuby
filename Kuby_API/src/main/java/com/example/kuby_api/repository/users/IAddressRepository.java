package com.example.kuby_api.repository.users;

import com.example.kuby_api.model.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
