package com.filipdishe.PetShop.controller;

import com.filipdishe.PetShop.dto.UserDto;
import com.filipdishe.PetShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-users")
    public ResponseEntity<List<UserDto>> createRandomUsers() {
        List<UserDto> generatedUsers = userService.createUsers();

        return new ResponseEntity<>(generatedUsers, HttpStatus.OK);
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<UserDto>> listAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();

        if(allUsers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allUsers);
        }
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyPets() {
        userService.buyPetsForUsers();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
