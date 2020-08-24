package com.lambda.watermyplants.services;


import com.lambda.watermyplants.exceptions.ResourceNotFoundException;
import com.lambda.watermyplants.models.Plant;
import com.lambda.watermyplants.models.User;
import com.lambda.watermyplants.repository.PlantRepository;
import com.lambda.watermyplants.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "plantService")
public class PlantServiceImpl implements PlantService {

    @Autowired
    PlantRepository plantrepos;

    @Autowired
    UserRepository userrepos;

    @Transactional
    @Override
    public List<Plant> findAllPlantsByUserID(long userid) {
        List<Plant> plantList = plantrepos.findAllByUser_Userid(userid);
        return plantList;
    }

    @Transactional
    @Override
    public Plant savePlant(long userID, Plant newPlant) {
        User user = userrepos.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("UserID does not exist")
        );
        newPlant.setUser(user);
        return plantrepos.save(newPlant);
    }

    @Override
    public Plant updatePlant(Plant plant, long plantid) {
        Plant currentPlant = plantrepos.findByPlantid(plantid);

        if (plant.getNickname() != null) {
            currentPlant.setNickname(plant.getNickname());
        }

        if (plant.getFrequency() != null) {
            currentPlant.setFrequency(plant.getFrequency());
        }

        if (plant.getSpecies() != null) {
            currentPlant.setSpecies(plant.getSpecies());
        }

        if (plant.getPhoto() != null) {
            currentPlant.setPhoto(plant.getPhoto());
        }
        return plantrepos.save(currentPlant);
    }

    @Override
    public void delete(long id) {
        plantrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plant id Not Found!"));
        plantrepos.deleteByPlantid(id);
    }

    @Transactional
    @Override
    public Plant save(Plant plant)
    {
        Plant newPlant = new Plant();

        newPlant.setUser(newPlant.getUser());
        newPlant.setFrequency(newPlant.getFrequency());
        newPlant.setPhoto(newPlant.getPhoto());
        newPlant.setSpecies(newPlant.getSpecies());
        newPlant.setNickname(newPlant.getNickname());


        return plantrepos.save(newPlant);
    }
}
