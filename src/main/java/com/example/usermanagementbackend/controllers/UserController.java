package com.example.usermanagementbackend.controllers;

import com.example.usermanagementbackend.entities.User;
import com.example.usermanagementbackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        List<User>users =userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User>findUser(@PathVariable("id") long id){
        User user =userService.findUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User>addUser(@RequestBody User user){    //converting user into json
        User newUser= userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<User>updateUser(@RequestBody User user){
        User updateUser= userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
