/**
 * @author: ntwari egide
 * @description: schools endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.dtos.SchoolDto;
import com.rashcomps.rashcomputers.models.Role;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.serviceImpl.RoleServiceImpl;
import com.rashcomps.rashcomputers.serviceImpl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/schools")

public class SchoolController {

    @Autowired
    private SchoolServiceImpl schoolService;

    @GetMapping
    public List<School> getAll(){
        return schoolService.findAll();
    }

    @GetMapping("/{id}")
    public School findById(@PathVariable Long id){
        return schoolService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        boolean isDeleted=schoolService.delete(id);

        return ResponseEntity.ok().build();

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody SchoolDto newSchool){

        School saved =schoolService.add(newSchool);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(saved.getId())

                .toUri();


        return  ResponseEntity.created(location).build();

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SchoolDto updates, @PathVariable Long id){

        School savedUpdates= schoolService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
