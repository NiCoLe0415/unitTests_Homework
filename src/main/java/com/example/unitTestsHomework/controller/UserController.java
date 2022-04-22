package com.example.unitTestsHomework.controller;
import com.example.unitTestsHomework.model.UserModel;
import com.example.unitTestsHomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{userId}")
    public UserModel getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/postUser")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @PutMapping("/updateUserById/{userId}")
    public void updateUser(@RequestBody UserModel userModel,@PathVariable Integer userId){
        userService.updateUser(userId,userModel);
    }
    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);

    }

}
