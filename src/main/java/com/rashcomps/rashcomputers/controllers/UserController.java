package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.dtos.CreateUser;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.serviceImpl.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @GetMapping
    private List<User> findAll(){
        return userServiceImplementation.findAll();
    }

    @GetMapping("/{id}")
    private User findById(@PathVariable Long id){
        return userServiceImplementation.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreateUser createUser){

        User savedUser = userServiceImplementation.signupNewUser(createUser);

        URI location  = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateUser updateUser){

        User savedUser =  userServiceImplementation.updateNewUser(id, updateUser);

        return ResponseEntity.ok().body(savedUser);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        userServiceImplementation.deleteProject(id);

        return ResponseEntity.ok().build();
    }

}
