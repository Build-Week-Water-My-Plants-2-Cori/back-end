package com.lambda.watermyplants.repository;

import com.lambda.watermyplants.models.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Long> {
    List<Plant> findAllByUser_Userid(long userId);

    Plant findByPlantid(long plantid);

    void deleteByPlantid(long plantid);
}
