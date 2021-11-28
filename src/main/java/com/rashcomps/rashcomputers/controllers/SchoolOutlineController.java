/**
 * @author: ntwari egide
 * @description: school outline endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.dtos.SchoolOutlineDto;
import com.rashcomps.rashcomputers.models.SchoolOutline;
import com.rashcomps.rashcomputers.serviceImpl.SchoolOutlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/school_outlines")

public class SchoolOutlineController {

    @Autowired
    private SchoolOutlineServiceImpl schoolOutlineService;

    @GetMapping
    public List<SchoolOutline> getAll(){
        return schoolOutlineService.findAll();
    }

    @GetMapping("/{id}")
    public SchoolOutline findById(@PathVariable Long id){
        return schoolOutlineService.findById(id);

    }

    @GetMapping("/schools/{id}")
    public List<SchoolOutline> findBySchool(@PathVariable Long id){
        return schoolOutlineService.findBySchool(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        boolean isDeleted=schoolOutlineService.delete(id);

        return ResponseEntity.ok().build();

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody SchoolOutlineDto newSchoolOutline){

        SchoolOutline saved =schoolOutlineService.add(newSchoolOutline);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(saved.getId())

                .toUri();


        return  ResponseEntity.created(location).build();

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SchoolOutlineDto updates, @PathVariable Long id){

        SchoolOutline savedUpdates= schoolOutlineService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
