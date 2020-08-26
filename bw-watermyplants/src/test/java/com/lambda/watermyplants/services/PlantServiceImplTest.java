package com.lambda.watermyplants.services;

import com.lambda.watermyplants.WaterMyPlantsBwApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WaterMyPlantsBwApplication.class)
public class PlantServiceImplTest {
    @Autowired
    PlantService plantservice;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllPlantsByUserID() {
        assertEquals("", plantservice.findAllPlantsByUserID(1));
    }

    @Test
    public void savePlant() {
    }

    @Test
    public void updatePlant() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void save() {
    }
}