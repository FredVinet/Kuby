package com.example.kuby_api.service;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public Optional<Adress> getAdress(final Long id){
        return adressRepository.findById(id);
    }

    public Iterable<Adress> getAdresses() {
        return adressRepository.findAll();
    }

    public void deleteAdress(final Long id){
        adressRepository.deleteById(id);
    }

    public Adress saveAdress(Adress adress){
        return adressRepository.save(adress);
    }
}
