package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.dtos.AddLesson;
import com.rashcomps.rashcomputers.dtos.UpdateLesson;
import com.rashcomps.rashcomputers.models.Lesson;
import com.rashcomps.rashcomputers.serviceImpl.LessonServicesImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lessons controller
 */

@RestController
@RequestMapping("/api/v1/lessons")
@CrossOrigin
public class LessonController {

    @Autowired
    private LessonServicesImplementation lessonServicesImplementation;

    @GetMapping
    private List<Lesson> findAll(){  return lessonServicesImplementation.getAll(); }

    @GetMapping("/{id}")
    private Lesson findById(@RequestParam Long id){

        return lessonServicesImplementation.findById(id);

    }


    @GetMapping("/archived/{archived}")
    private List<Lesson> getArchived(@RequestParam Boolean archived){

        return lessonServicesImplementation.findByArchivedAndPublishedStatuses(true,archived);

    }

    @GetMapping("/published/{published}")
    private List<Lesson> getByPublishedStatus(@RequestParam Boolean published){

        return lessonServicesImplementation.findByArchivedAndPublishedStatuses(true,published);

    }

    @PostMapping
    private ResponseEntity<?> addNew(@Valid @RequestBody AddLesson lesson){

        Lesson savedLesson = lessonServicesImplementation.addNewLesson(lesson);

        URI location  = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedLesson.getId())

                .toUri();


        return ResponseEntity.created(location).body(savedLesson);

    }

    @PutMapping("/{id}")

    private ResponseEntity<?> update(@RequestParam Long id ,@Valid @RequestBody UpdateLesson lesson){

        Lesson savedLesson = lessonServicesImplementation.updateById(id, lesson);

        URI location  = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedLesson.getId())

                .toUri();


        return ResponseEntity.created(location).body(savedLesson);

    }

    @DeleteMapping("/{id}")

    private ResponseEntity<?> delete(@RequestParam Long id){

        lessonServicesImplementation.deleteById(id);

        return ResponseEntity.ok().build();

    }


}
