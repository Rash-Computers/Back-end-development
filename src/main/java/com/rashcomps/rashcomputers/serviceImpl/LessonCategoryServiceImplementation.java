package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.AddCategoryLesson;
import com.rashcomps.rashcomputers.dtos.UpdateCategoryLesson;
import com.rashcomps.rashcomputers.exceptions.LessonCategoryNotFoundException;
import com.rashcomps.rashcomputers.models.LessonCategory;
import com.rashcomps.rashcomputers.repositories.LessonCategoryRepository;
import com.rashcomps.rashcomputers.services.LessonCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson category service implementation
 */

@Service

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
    public LessonCategory changeArchiveArchiveStatus(Long id, Boolean isArchived) {

        Optional<LessonCategory> lessonCategoryOptional = lessonCategoryRepository.findById(id);

        if(! lessonCategoryOptional.isPresent()) throw new LessonCategoryNotFoundException("Lesson category with id : "+id+" not found");

        LessonCategory category = new LessonCategory(
                lessonCategoryOptional.get().getName(),
                lessonCategoryOptional.get().getDescription(),
                lessonCategoryOptional.get().getCoverImageUrl()
        );

        category.setId(id);

        category.setArchived(isArchived);

        category.setPublished(lessonCategoryOptional.get().getPublished());

        return lessonCategoryRepository.save(category);
    }

    @Override
    public LessonCategory changePublishStatus(Long id, Boolean isPublished) {
        Optional<LessonCategory> lessonCategoryOptional = lessonCategoryRepository.findById(id);

        if(! lessonCategoryOptional.isPresent()) throw new LessonCategoryNotFoundException("Lesson category with id : "+id+" not found");

        LessonCategory category = new LessonCategory(
                lessonCategoryOptional.get().getName(),
                lessonCategoryOptional.get().getDescription(),
                lessonCategoryOptional.get().getCoverImageUrl()
        );

        category.setId(id);

        category.setArchived(lessonCategoryOptional.get().getArchived());

        category.setPublished(isPublished);

        return lessonCategoryRepository.save(category);
    }


    @Override
    public List<LessonCategory> findByArchivedAndPublishedStatuses(Boolean isPublished, Boolean isArchived) {
        return lessonCategoryRepository.findByIsPublishedAndIsArchived(isPublished,isArchived);
    }
}
