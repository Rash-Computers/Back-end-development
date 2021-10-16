package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.dtos.AddCategoryLesson;
import com.rashcomps.rashcomputers.models.LessonCategory;
import com.rashcomps.rashcomputers.serviceImpl.LessonCategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson category controller
 */


@RestController

@CrossOrigin

@RequestMapping("/api/v1/lesson-categories")

public class LessonCategoryController {

    @Autowired
    private LessonCategoryServiceImplementation lessonCategoryServiceImplementation;

    @GetMapping
    private List<LessonCategory> findAll(){  return lessonCategoryServiceImplementation.getAll(); }

    @GetMapping("/{id}")
    private LessonCategory findById(@RequestParam Long id){

        return lessonCategoryServiceImplementation.findById(id);

    }


    @GetMapping("/archived/{archived}")
    private List<LessonCategory> getArchived(@RequestParam Boolean archived){

        return lessonCategoryServiceImplementation.findByArchivedAndPublishedStatuses(true,archived);

    }

    @GetMapping("/published/{published}")
    private List<LessonCategory> getByPublishedStatus(@RequestParam Boolean published){

        return lessonCategoryServiceImplementation.findByArchivedAndPublishedStatuses(true,published);

    }

    @PostMapping
    private ResponseEntity<?> addNew(@Valid @RequestBody AddCategoryLesson categoryLesson){

        LessonCategory savedCategory = lessonCategoryServiceImplementation.addNewLessonCategory(categoryLesson);

        URI location  = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedCategory.getId())

                .toUri();


        return ResponseEntity.created(location).body(savedCategory);

    }


}
