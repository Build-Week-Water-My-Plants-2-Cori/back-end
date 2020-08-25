package com.lambda.watermyplants;

import com.lambda.watermyplants.models.Role;
import com.lambda.watermyplants.models.User;
import com.lambda.watermyplants.models.UserRoles;
import com.lambda.watermyplants.services.RoleService;
import com.lambda.watermyplants.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        // admin, data, user
        User u1 = new User("admin", "password", "admin@lambdaschool.local", "123-456-7890");
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));
        u1.getRoles().add(new UserRoles(u1, r3));
        userService.save(u1);

        // data, user
        User u2 = new User("Test cinnamon", "1234567", "cinnamon@lambdaschool.local", "098-765-5432");
        u2.getRoles().add(new UserRoles(u2, r2));
        u2.getRoles().add(new UserRoles(u2, r3));
        userService.save(u2);

        // user
        User u3 = new User("Test barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local", "dsad");
        u3.getRoles().add(new UserRoles(u3, r2));
        userService.save(u3);

        User u4 = new User("Test puttat", "password", "puttat@school.lambda", "fds");
        u4.getRoles().add(new UserRoles(u4, r2));
        userService.save(u4);

        User u5 = new User("Test misskitty", "password", "misskitty@school.lambda", "asd");
        u5.getRoles().add(new UserRoles(u5, r2));
        userService.save(u5);
    }
}