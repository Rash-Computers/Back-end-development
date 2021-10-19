package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.RegisterLessonVideo;
import com.rashcomps.rashcomputers.dtos.UpdateLessonVideo;
import com.rashcomps.rashcomputers.models.LessonVideo;
import com.rashcomps.rashcomputers.repositories.LessonVideoRepository;
import com.rashcomps.rashcomputers.services.LessonVideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson video service implementation
 */

@Service
public class LessonVideoServiceImplementation implements LessonVideoServices {

    @Autowired
    private LessonVideoRepository lessonVideoRepository;

    @Override
    public List<LessonVideo> getAll() {
        return lessonVideoRepository.findAll();
    }

    @Override
    public LessonVideo findById(Long id) {
        return null;
    }

    @Override
    public LessonVideo registerNew(RegisterLessonVideo lessonVideo) {
        return null;
    }

    @Override
    public LessonVideo updateById(Long id, UpdateLessonVideo updateLessonVideo) {
        return null;
    }

    @Override
    public LessonVideo deleteById(Long id) {
        return null;
    }

    @Override
    public LessonVideo changeArchiveStatus(Long id, Boolean isArchived) {
        return null;
    }

    @Override
    public LessonVideo changePublishStatus(Long id, Boolean isPublished) {
        return null;
    }

    @Override
    public List<LessonVideo> findByArchivedAndPublishedStatuses(Boolean isPublished, Boolean isArchived) {
        return null;
    }
}
