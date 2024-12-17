package com.example.kuby_api.service;

import com.example.kuby_api.model.Family;
import com.example.kuby_api.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public Optional<Family> getFamily(final Long id){
        return familyRepository.findById(id);
    }

    public Iterable<Family> getFamilies() {
        return familyRepository.findAll();
    }

    public void deleteFamily(final Long id){
        familyRepository.deleteById(id);
    }

    public Family saveFamily(Family family){
        return familyRepository.save(family);
    }
}
