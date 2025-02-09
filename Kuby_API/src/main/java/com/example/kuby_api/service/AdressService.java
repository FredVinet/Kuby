package com.example.kuby_api.service;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.model.Localisation;
import com.example.kuby_api.repository.AdressRepository;
import com.example.kuby_api.repository.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private LocalisationRepository localisationRepository;

    public Optional<Adress> getAdress(final Long id){
        return adressRepository.findById(id);
    }

    public Iterable<Adress> getAdresses() {
        return adressRepository.findAll();
    }

    public void deleteAdress(final Long id){
        List<Localisation> localisations = localisationRepository.findByIdAdress(id);

        // Supprimer toutes les localisations associées
        localisationRepository.deleteAll(localisations);
        adressRepository.deleteById(id);
    }

    public Adress saveAdress(Adress adress){
        return adressRepository.save(adress);
    }
}