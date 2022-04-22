package com.example.unitTestsHomework.unit;

import com.example.unitTestsHomework.model.UserModel;
import com.example.unitTestsHomework.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void whenCreateUser_ThenIHaveToHaveOneInTheList() {
        UserModel user = new UserModel();
        user.setUsername("username1");
        user.setFirstName("Dorobantu");
        user.setLastName("Nicoleta");
        userService.createUser(user);
        Assertions.assertEquals(1, userService.getAllUsers().size());
    }
}
