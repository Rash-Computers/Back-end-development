package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.AddLesson;
import com.rashcomps.rashcomputers.dtos.UpdateLesson;
import com.rashcomps.rashcomputers.models.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson services
 */




@Service

public interface LessonServices {
    Lesson addNewLesson(AddLesson newLesson);

    List<Lesson> getAll();

    Lesson findById(Long id);

    Lesson updateById(Long id, UpdateLesson updateLesson);

    Boolean deleteById(Long id);

    Lesson changeArchiveStatus(Long id, Boolean isArchived);

    Lesson changePublishStatus(Long id,Boolean isPublished);

    List<Lesson> findByArchivedAndPublishedStatuses(Boolean isPublished, Boolean isArchived);


}
