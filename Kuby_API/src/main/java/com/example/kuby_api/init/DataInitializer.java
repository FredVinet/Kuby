package com.example.kuby_api.init;

import com.example.kuby_api.model.Wines.WineFamily;
import com.example.kuby_api.model.Wines.WineTerroir;
import com.example.kuby_api.model.Wines.WineVariety;
import com.example.kuby_api.repository.wines.IWineFamilyRepository;
import com.example.kuby_api.repository.wines.IWineTerroirRepository;
import com.example.kuby_api.repository.wines.IWineVarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private IWineFamilyRepository wineFamilyRepository;
    @Autowired
    private IWineTerroirRepository wineTerroirRepository;
    @Autowired
    private IWineVarietyRepository wineVarietyRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            if(wineFamilyRepository.count() == 0) {
                List<WineFamily> wineFamilies = Arrays.asList(
                        new WineFamily(null, "Rouge"),
                        new WineFamily(null, "Blanc"),
                        new WineFamily(null, "Rosé"),
                        new WineFamily(null, "Pétillant")
                );
                wineFamilyRepository.saveAll(wineFamilies);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            if(wineTerroirRepository.count() == 0) {
                List<WineTerroir> wineTerroirs = Arrays.asList(
                        new WineTerroir(null, "Bordeau", "France"),
                        new WineTerroir(null, "Madiran", "France"),
                        new WineTerroir(null, "Pic St Loup", "France"),
                        new WineTerroir(null, "Cotes du Rhone", "France"),
                        new WineTerroir(null, "Alsace", "France"),
                        new WineTerroir(null, "Chateaux de la Loire", "France"),
                        new WineTerroir(null, "Californie", "EU"),
                        new WineTerroir(null, "Marlborough", "New Zeland"),
                        new WineTerroir(null, "Pico", "Açoria")
                );
                wineTerroirRepository.saveAll(wineTerroirs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            if(wineVarietyRepository.count() == 0) {
                List<WineVariety> wineVarieties = Arrays.asList(
                        new WineVariety(null, "Sauvignon"),
                        new WineVariety(null, "Riesling"),
                        new WineVariety(null, "Gewurztraminer"),
                        new WineVariety(null, "Syrah"),
                        new WineVariety(null, "Chardonnay"),
                        new WineVariety(null, "Merlot"),
                        new WineVariety(null, "Grenache noir"),
                        new WineVariety(null, "Carignan"),
                        new WineVariety(null, "Pinot noir"),
                        new WineVariety(null, "Cabernet")
                );
                wineVarietyRepository.saveAll(wineVarieties);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
