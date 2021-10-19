package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.dtos.RegisterLessonVideo;
import com.rashcomps.rashcomputers.dtos.UpdateLessonVideo;
import com.rashcomps.rashcomputers.models.LessonVideo;
import com.rashcomps.rashcomputers.serviceImpl.LessonVideoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lessons videos controller
 */

public class LessonsVideosController {

    @Autowired
    private LessonVideoServiceImplementation lessonVideoServiceImplementation;

    @GetMapping
    private List<LessonVideo> findAll(){  return lessonVideoServiceImplementation.getAll(); }

    @GetMapping("/{id}")
    private LessonVideo findById(@RequestParam Long id){

        return lessonVideoServiceImplementation.findById(id);

    }


    @GetMapping("/archived/{archived}")
    private List<LessonVideo> getArchived(@RequestParam Boolean archived){

        return lessonVideoServiceImplementation.findByArchivedAndPublishedStatuses(true,archived);

    }

    @GetMapping("/published/{published}")
    private List<LessonVideo> getByPublishedStatus(@RequestParam Boolean published){

        return lessonVideoServiceImplementation.findByArchivedAndPublishedStatuses(true,published);

    }

    @PostMapping
    private ResponseEntity<?> addNew(@Valid @RequestBody RegisterLessonVideo video){

        LessonVideo savedVideo = lessonVideoServiceImplementation.registerNew(video);

        URI location  = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedVideo.getId())

                .toUri();


        return ResponseEntity.created(location).body(savedVideo);

    }

    @PutMapping("/{id}")

    private ResponseEntity<?> update(@RequestParam Long id ,@Valid @RequestBody UpdateLessonVideo updateLessonVideo){

        LessonVideo savedVideo = lessonVideoServiceImplementation.updateById(id, updateLessonVideo);

        URI location  = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedVideo.getId())

                .toUri();


        return ResponseEntity.created(location).body(savedVideo);

    }

    @DeleteMapping("/{id}")

    private ResponseEntity<?> delete(@RequestParam Long id){

        lessonVideoServiceImplementation.deleteById(id);

        return ResponseEntity.ok().build();

    }


}
