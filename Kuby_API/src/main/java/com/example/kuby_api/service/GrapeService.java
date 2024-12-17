package com.example.kuby_api.service;

import com.example.kuby_api.model.Grape;
import com.example.kuby_api.repository.GrapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class GrapeService {

    @Autowired
    private GrapeRepository grapeRepository;

    public Optional<Grape> getGrape(final Long id){
        return grapeRepository.findById(id);
    }

    public Iterable<Grape> getGrapes() {
        return grapeRepository.findAll();
    }

    public void deleteGrape(final Long id){
        grapeRepository.deleteById(id);
    }

    public Grape saveGrape(Grape grape){
        return grapeRepository.save(grape);
    }
}
