package com.lambda.watermyplants.controllers;


import com.lambda.watermyplants.models.Plant;
import com.lambda.watermyplants.services.PlantService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    PlantService plantService;

    @GetMapping(value = "/user/{userid}", produces = "application/json")
    public ResponseEntity<?> getPlantsByUserID(@PathVariable Long userid) {
        List<Plant> userPlants = plantService.findAllPlantsByUserID(userid);
        return new ResponseEntity<>(userPlants, HttpStatus.OK);
    }

    @PostMapping(value = "/{userID}", consumes = "application/json")
    public ResponseEntity<?> saveNewPlant(
            HttpServletRequest request,
            @ApiParam(value = "User ID", required = true) @PathVariable long userID,
            @Valid @RequestBody Plant newPlant
    ) throws URISyntaxException {
        Plant plant = plantService.savePlant(userID, newPlant);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPlantURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{plantid}")
                .buildAndExpand(plant.getPlantid())
                .toUri();

        responseHeaders.setLocation(newPlantURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.OK);
    }

    @PutMapping(value = "/{plantid}", consumes = "application/json")
    public ResponseEntity<?> updatePlant(HttpServletRequest request, @RequestBody Plant changedPlant, @PathVariable int plantid) {
        changedPlant.setPlantid(plantid);
        plantService.updatePlant(changedPlant, plantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{plantid}")
    public ResponseEntity<?> deletePlant(@PathVariable long plantid) {
        plantService.delete(plantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
