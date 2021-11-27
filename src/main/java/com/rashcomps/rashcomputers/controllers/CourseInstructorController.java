/**
 * @author: ntwari egide
 * @description: course instructor endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.dtos.CourseInstructorDto;
import com.rashcomps.rashcomputers.models.CourseInstructor;
import com.rashcomps.rashcomputers.serviceImpl.CourseInstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/courses_instructors")

public class CourseInstructorController {

    @Autowired
    private CourseInstructorServiceImpl courseInstructorService;

    @GetMapping
    public List<CourseInstructor> getAll(){
        return courseInstructorService.findAll();
    }

    @GetMapping("/{id}")
    public CourseInstructor findById(@PathVariable Long id){
        return courseInstructorService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        CourseInstructor deleted =courseInstructorService.delete(id);

        return ResponseEntity.status(200).body(deleted);

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody CourseInstructorDto newInsructor){

        CourseInstructor saved =courseInstructorService.add(newInsructor);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(saved.getId())

                .toUri();


        return  ResponseEntity.ok(saved);

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CourseInstructorDto updates, @PathVariable Long id){

        CourseInstructor savedUpdates= courseInstructorService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
