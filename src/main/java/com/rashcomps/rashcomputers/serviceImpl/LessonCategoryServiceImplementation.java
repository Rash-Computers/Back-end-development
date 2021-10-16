package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.AddCategoryLesson;
import com.rashcomps.rashcomputers.dtos.UpdateCategoryLesson;
import com.rashcomps.rashcomputers.exceptions.LessonCategoryNotFoundException;
import com.rashcomps.rashcomputers.models.LessonCategory;
import com.rashcomps.rashcomputers.repositories.LessonCategoryRepository;
import com.rashcomps.rashcomputers.services.LessonCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson category service implementation
 */


public class LessonCategoryServiceImplementation implements LessonCategoryService {

    @Autowired
    private LessonCategoryRepository lessonCategoryRepository;

    @Override
    public LessonCategory addNewLessonCategory(AddCategoryLesson newLessonCategory) {

        LessonCategory lessonCategory = new LessonCategory(
                newLessonCategory.getName(),
                newLessonCategory.getDescription(),
                newLessonCategory.getCoverImageUrl()
        );

        LessonCategory category = lessonCategoryRepository.save(lessonCategory);

        return category;
    }

    @Override
    public List<LessonCategory> getAll() {

        return lessonCategoryRepository.findAll();
    }

    @Override
    public LessonCategory findById(Long id) {

        Optional<LessonCategory> lessonCategoryOptional = lessonCategoryRepository.findById(id);

        if(! lessonCategoryOptional.isPresent()) throw new LessonCategoryNotFoundException("Lesson category with id : "+id+" not found");

        return lessonCategoryOptional.get();
    }

    @Override
    public LessonCategory updateById(Long id, UpdateCategoryLesson updateCategoryLesson) {

        Optional<LessonCategory> lessonCategoryOptional = lessonCategoryRepository.findById(id);

        if(! lessonCategoryOptional.isPresent()) throw new LessonCategoryNotFoundException("Lesson category with id : "+id+" not found");

        LessonCategory updateCategory = new LessonCategory(
                updateCategoryLesson.getName(),
                updateCategoryLesson.getDescription(),
                updateCategoryLesson.getCoverImageUrl()
        );

        updateCategory.setId(id);

        return lessonCategoryRepository.save(updateCategory);
    }

    @Override
    public Boolean deleteById(Long id) {

        Optional<LessonCategory> lessonCategoryOptional = lessonCategoryRepository.findById(id);

        if(! lessonCategoryOptional.isPresent()) throw new LessonCategoryNotFoundException("Lesson category with id : "+id+" not found");

        lessonCategoryRepository.deleteById(id);

        return true;
    }

    @Override
    public List<LessonCategory> changeArchiveArchiveStatus(Long id, Boolean isArchived) {

        return lessonCategoryRepository.findByIsPublishedAndIsArchived(isArchived,true);
    }

    @Override
    public List<LessonCategory> changePublishStatus(Long id, Boolean isPublished) {

        return lessonCategoryRepository.findByIsPublishedAndIsArchived(isPublished, true);

    }
}
