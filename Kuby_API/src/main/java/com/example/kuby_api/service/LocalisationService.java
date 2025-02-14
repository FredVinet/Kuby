package com.example.kuby_api.service;

import com.example.kuby_api.model.Localisation;
import com.example.kuby_api.repository.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class LocalisationService {

    @Autowired
    private LocalisationRepository localisationRepository;

    public Optional<Localisation> getLocalisation(final Long id){
        return localisationRepository.findById(id);
    }

    public Iterable<Localisation> getLocalisations() {
        return localisationRepository.findAll();
    }

    public void deleteLocalisation(final Long id){
        localisationRepository.deleteById(id);
    }

    public Localisation saveLocalisation(Localisation localisation){
        return localisationRepository.save(localisation);
    }

    public Localisation getLocalisationByAdressId(Long adressId) {
        List<Localisation> localisations = localisationRepository.findByIdAdress(adressId);
        return localisations.isEmpty() ? null : localisations.get(0); // Prend la première localisation trouvée
    }

}