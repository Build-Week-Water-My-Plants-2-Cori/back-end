package com.lambda.watermyplants.services;


import com.lambda.watermyplants.models.Plant;

import java.util.List;

public interface PlantService {

    List<Plant> findAllPlantsByUserID(long userid);

    Plant save(Plant plant);
    Plant savePlant(long userID, Plant newPlant);
    Plant updatePlant(Plant plant, long plantid);
    void delete(long id);
    List<Plant> findAllPlants();
}
