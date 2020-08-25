package com.lambda.watermyplants.services;

import com.lambda.watermyplants.WaterMyPlantsBwApplication;
import com.lambda.watermyplants.exceptions.ResourceNotFoundException;
import com.lambda.watermyplants.models.Role;
import com.lambda.watermyplants.models.User;
import com.lambda.watermyplants.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WaterMyPlantsBwApplication.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() {
        assertEquals("admin", userService.findUserById(4).getUsername());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void findUserNotById() {
        assertEquals("admin", userService.findUserById(110).getUsername());
    }

    @Test
    public void findByNameContaining() {
        assertEquals(4, userService.findByNameContaining("a").size());
    }

    @Test
    public void findAll() {
        assertEquals(5, userService.findAll().size());
    }

    @Test
    public void delete() {
        userService.delete(8);
        assertEquals(4, userService.findAll().size());
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteAll() {
    }
}