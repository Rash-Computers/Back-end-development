package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.RegisterLessonVideo;
import com.rashcomps.rashcomputers.dtos.UpdateLessonVideo;
import com.rashcomps.rashcomputers.models.LessonVideo;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson video services
 */

@Service
public interface LessonVideoServices {

    List<LessonVideo> getAll();

    LessonVideo findById(Long id);

    LessonVideo registerNew(RegisterLessonVideo lessonVideo);

    LessonVideo updateById(Long id, UpdateLessonVideo updateLessonVideo);

    LessonVideo deleteById(Long id);

    LessonVideo changeArchiveStatus(Long id, Boolean isArchived);

    LessonVideo changePublishStatus(Long id,Boolean isPublished);

    List<LessonVideo> findByArchivedAndPublishedStatuses(Boolean isPublished, Boolean isArchived);


}
