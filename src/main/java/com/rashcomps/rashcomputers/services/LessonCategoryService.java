package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.AddCategoryLesson;
import com.rashcomps.rashcomputers.dtos.UpdateCategoryLesson;
import com.rashcomps.rashcomputers.models.LessonCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson category service
 */


@Service

public interface LessonCategoryService {

    LessonCategory addNewLessonCategory(AddCategoryLesson newLessonCategory);

    List<LessonCategory> getAll();

    LessonCategory findById(Long id);

    LessonCategory updateById(Long id, UpdateCategoryLesson updateCategoryLesson);

    Boolean deleteById(Long id);

    LessonCategory changeArchiveArchiveStatus(Long id, Boolean isArchived);

    LessonCategory changePublishStatus(Long id,Boolean isPublished);

    List<LessonCategory> findByArchivedAndPublishedStatuses(Boolean isPublished, Boolean isArchived);

}
