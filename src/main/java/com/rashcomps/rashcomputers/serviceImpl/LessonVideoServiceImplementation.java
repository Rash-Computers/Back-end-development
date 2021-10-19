package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.RegisterLessonVideo;
import com.rashcomps.rashcomputers.dtos.UpdateLessonVideo;
import com.rashcomps.rashcomputers.exceptions.LessonNotFoundException;
import com.rashcomps.rashcomputers.exceptions.LessonVideoNotFoundException;
import com.rashcomps.rashcomputers.models.Lesson;
import com.rashcomps.rashcomputers.models.LessonVideo;
import com.rashcomps.rashcomputers.repositories.LessonRepository;
import com.rashcomps.rashcomputers.repositories.LessonVideoRepository;
import com.rashcomps.rashcomputers.services.LessonVideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson video service implementation
 */

@Service
public class LessonVideoServiceImplementation implements LessonVideoServices {

    @Autowired
    private LessonVideoRepository lessonVideoRepository;

    @Autowired
    private LessonRepository lessonRepository;


    private LessonVideo checkVideoExistence(Long id){
        Optional<LessonVideo> lessonVideoOptional = lessonVideoRepository.findById(id);

        if(! lessonVideoOptional.isPresent()) throw new LessonVideoNotFoundException("Lesson with id: "+id+" is not found! ");

        return lessonVideoOptional.get();
    }

    @Override
    public List<LessonVideo> getAll() {
        return lessonVideoRepository.findAll();
    }

    @Override
    public LessonVideo findById(Long id) {
        return checkVideoExistence(id);
    }

    @Override
    public LessonVideo registerNew(RegisterLessonVideo lessonVideo) {


        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonVideo.getRelatedLesson().getId());

        if(! lessonOptional.isPresent() ) throw new LessonNotFoundException("Lesson with id: "+lessonVideo.getRelatedLesson().getId()+" is not found");

        LessonVideo newVideo = new LessonVideo(
                lessonOptional.get(),
                lessonVideo.getVideoUrl(),
                lessonVideo.getPublished(),
                lessonVideo.getArchived()
        );

        return lessonVideoRepository.save(newVideo);
    }

    @Override
    public LessonVideo updateById(Long id, UpdateLessonVideo updateLessonVideo) {

        LessonVideo video = checkVideoExistence(id);

        Optional<Lesson> lessonOptional = lessonRepository.findById(updateLessonVideo.getRelatedLesson().getId());

        if(! lessonOptional.isPresent() ) throw new LessonNotFoundException("Lesson with id: "+updateLessonVideo.getRelatedLesson().getId()+" is not found");


        LessonVideo updatedVideo = new LessonVideo(
                lessonOptional.get(),
                updateLessonVideo.getVideoUrl(),
                updateLessonVideo.getPublished(),
                updateLessonVideo.getArchived()
        );

        updatedVideo.setId(id);

        return lessonVideoRepository.save(updatedVideo);
    }

    @Override
    public LessonVideo deleteById(Long id) {

        LessonVideo deletedVideo = checkVideoExistence(id);

        lessonVideoRepository.deleteById(id);

        return deletedVideo;
    }

    @Override
    public LessonVideo changeArchiveStatus(Long id, Boolean isArchived) {

        LessonVideo videoFound = checkVideoExistence(id);

        LessonVideo updatedVideo = new LessonVideo(
                videoFound.getRelatedLesson(),
                videoFound.getVideoUrl(),
                videoFound.getPublished(),
                isArchived
        );

        updatedVideo.setId(id);

        return lessonVideoRepository.save(updatedVideo);
    }

    @Override
    public LessonVideo changePublishStatus(Long id, Boolean isPublished) {

        LessonVideo videoFound = checkVideoExistence(id);

        LessonVideo updatedVideo = new LessonVideo(
                videoFound.getRelatedLesson(),
                videoFound.getVideoUrl(),
                isPublished,
                videoFound.getArchived()
        );

        updatedVideo.setId(id);

        return lessonVideoRepository.save(updatedVideo);

    }

    @Override
    public List<LessonVideo> findByArchivedAndPublishedStatuses(Boolean isPublished, Boolean isArchived) {

        return lessonVideoRepository.findByIsArchivedAndIsPublished(isArchived,isPublished);

    }
}
