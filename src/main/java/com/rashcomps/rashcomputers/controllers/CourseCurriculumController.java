/**
 * @author: ntwari egide
 * @description: course curriculum endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.dtos.CourseCurriculumDto;
import com.rashcomps.rashcomputers.dtos.CoursePrerequisiteDto;
import com.rashcomps.rashcomputers.models.CourseCurriculum;
import com.rashcomps.rashcomputers.models.CoursePrerequisite;
import com.rashcomps.rashcomputers.serviceImpl.CourseCurriculumServiceImpl;
import com.rashcomps.rashcomputers.serviceImpl.CoursePrerequisiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/courses_curriculums")

public class CourseCurriculumController {

    @Autowired
    private CourseCurriculumServiceImpl courseCurriculumService;

    @GetMapping
    public List<CourseCurriculum> getAll(){
        return courseCurriculumService.findAll();
    }

    @GetMapping("/{id}")
    public CourseCurriculum findById(@PathVariable Long id){
        return courseCurriculumService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        CourseCurriculum deleted =courseCurriculumService.delete(id);

        return ResponseEntity.status(200).body(deleted);

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody CourseCurriculumDto newCurriculum){

        CourseCurriculum saved =courseCurriculumService.add(newCurriculum);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(saved.getId())

                .toUri();


        return  ResponseEntity.ok(saved);

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CourseCurriculumDto updates, @PathVariable Long id){

        CourseCurriculum savedUpdates= courseCurriculumService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
