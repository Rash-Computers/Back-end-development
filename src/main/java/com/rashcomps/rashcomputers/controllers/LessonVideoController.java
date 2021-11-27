/**
 * @author: ntwari egide
 * @description: lessons videos endpoints controller
 */

package com.rashcomps.rashcomputers.controllers;


import com.rashcomps.rashcomputers.dtos.LessonVideoDto;
import com.rashcomps.rashcomputers.models.LessonVideo;
import com.rashcomps.rashcomputers.serviceImpl.LessonVideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/lessons_videos")

public class LessonVideoController {

    @Autowired
    private LessonVideoServiceImpl lessonVideoService;

    @GetMapping
    public List<LessonVideo> getAll(){
        return lessonVideoService.findAll();
    }

    @GetMapping("/{id}")
    public LessonVideo findById(@PathVariable Long id){
        return lessonVideoService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        LessonVideo deleted =lessonVideoService.delete(id);

        return ResponseEntity.status(200).body(deleted);

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody LessonVideoDto newVideo){

        LessonVideo saved =lessonVideoService.add(newVideo);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(saved.getId())

                .toUri();


        return  ResponseEntity.ok(saved);

    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody LessonVideoDto updates, @PathVariable Long id){

        LessonVideo savedUpdates= lessonVideoService.update(updates,id);

        return ResponseEntity.ok(savedUpdates);
    }
}
