/**
 * @author: ntwari egide
 * @description: roles endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.models.Role;
import com.rashcomps.rashcomputers.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/roles")

public class RolesController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping
    public List<Role> getAll(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Long id){
        return roleService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        boolean isDeleted=roleService.delete(id);

        return ResponseEntity.ok().build();

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody Role newRole){

        Role savedRole =roleService.add(newRole);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedRole.getId())

                .toUri();


        return  ResponseEntity.created(location).build();

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Role updates, @PathVariable Long id){

        Role savedUpdates= roleService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
