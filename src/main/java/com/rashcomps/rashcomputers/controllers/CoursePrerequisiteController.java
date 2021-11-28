/**
 * @author: ntwari egide
 * @description: course prerequisite endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.dtos.CoursePrerequisiteDto;
import com.rashcomps.rashcomputers.dtos.SchoolDto;
import com.rashcomps.rashcomputers.models.CoursePrerequisite;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.serviceImpl.CoursePrerequisiteServiceImpl;
import com.rashcomps.rashcomputers.serviceImpl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/course_prerequisite")

public class CoursePrerequisiteController {

    @Autowired
    private CoursePrerequisiteServiceImpl coursePrerequisiteService;

    @GetMapping
    public List<CoursePrerequisite> getAll(){
        return coursePrerequisiteService.findAll();
    }

    @GetMapping("/{id}")
    public CoursePrerequisite findById(@PathVariable Long id){
        return coursePrerequisiteService.findById(id);

    }

    @GetMapping("/schools/{id}")
    public List<CoursePrerequisite> findBySchool(@PathVariable Long id){
        return coursePrerequisiteService.findBySchool(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        CoursePrerequisite deleted =coursePrerequisiteService.delete(id);

        return ResponseEntity.status(200).body(deleted);

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody CoursePrerequisiteDto newPrerequisite){

        CoursePrerequisite saved =coursePrerequisiteService.add(newPrerequisite);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(saved.getId())

                .toUri();


        return  ResponseEntity.ok(saved);

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CoursePrerequisiteDto updates, @PathVariable Long id){

        CoursePrerequisite savedUpdates= coursePrerequisiteService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
