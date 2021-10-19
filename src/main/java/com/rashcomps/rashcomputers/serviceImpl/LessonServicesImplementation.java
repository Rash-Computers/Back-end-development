package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.AddLesson;
import com.rashcomps.rashcomputers.dtos.IdTemplate;
import com.rashcomps.rashcomputers.dtos.UpdateLesson;
import com.rashcomps.rashcomputers.exceptions.LessonNotFoundException;
import com.rashcomps.rashcomputers.models.Lesson;
import com.rashcomps.rashcomputers.models.LessonCategory;
import com.rashcomps.rashcomputers.repositories.LessonCategoryRepository;
import com.rashcomps.rashcomputers.repositories.LessonRepository;
import com.rashcomps.rashcomputers.services.LessonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson service implementation
 */


@Service

public class LessonServicesImplementation implements LessonServices {

    @Autowired
    private LessonCategoryRepository lessonCategoryRepository;

    @Autowired
    private LessonRepository lessonRepository;


    private List<LessonCategory> getLessonCategoriesById (List<IdTemplate> listIds) {
        List<LessonCategory> lessonCategories = new ArrayList<>();

        for (IdTemplate idTemplate: listIds){

            Optional<LessonCategory> category = lessonCategoryRepository.findById(idTemplate.getId());

            if( ! category.isPresent()) throw new LessonNotFoundException("Lesson category with id "+idTemplate.getId()+" is not found");

            lessonCategories.add(category.get());

        }

        return lessonCategories;
    }

    private Lesson checkLessonExistance (Long id) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(id);

        if( ! lessonOptional.isPresent() ) throw new LessonNotFoundException("Lesson with id: "+id+" is not found");

        return lessonOptional.get();
    }

    @Override
    public Lesson addNewLesson(AddLesson newLesson) {

        Lesson lesson = new Lesson(
                newLesson.getName(),
                newLesson.getContents(),
                getLessonCategoriesById(newLesson.getLessonCategory()),
                newLesson.getCoverImageUrl(),
                newLesson.getPublished(),
                newLesson.getArchived()
        );

        return lessonRepository.save(lesson);

    }

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(Long id) {
        return checkLessonExistance(id);
    }



    @Override
    public Lesson updateById(Long id, UpdateLesson updateLesson) {

        checkLessonExistance(id);

        Lesson lesson = new Lesson(
                updateLesson.getName(),
                updateLesson.getContents(),
                getLessonCategoriesById(updateLesson.getLessonCategory()),
                updateLesson.getCoverImageUrl(),
                updateLesson.getPublished(),
                updateLesson.getArchived()
        );


        lesson.setId(id);

        return lessonRepository.save(lesson);
    }

    @Override
    public Boolean deleteById(Long id) {

        checkLessonExistance(id);

        lessonRepository.deleteById(id);

        return true;
    }

    @Override
    public Lesson changeArchiveStatus(Long id, Boolean isArchived) {

        Lesson updateLesson = checkLessonExistance(id);

        Lesson lesson = new Lesson(
                updateLesson.getName(),
                updateLesson.getContents(),
                updateLesson.getLessonCategory(),
                updateLesson.getCoverImageUrl(),
                updateLesson.getPublished(),
                isArchived
        );


        lesson.setId(id);

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson changePublishStatus(Long id, Boolean isPublished) {

        Lesson updateLesson = checkLessonExistance(id);

        Lesson lesson = new Lesson(
                updateLesson.getName(),
                updateLesson.getContents(),
                updateLesson.getLessonCategory(),
                updateLesson.getCoverImageUrl(),
                isPublished,
                updateLesson.getArchived()
        );


        lesson.setId(id);

        return lessonRepository.save(lesson);

    }

    @Override
    public List<Lesson> findByArchivedAndPublishedStatuses( Boolean isPublished, Boolean isArchived) {

        return lessonRepository.findByIsPublishedAndIsArchived(isPublished, isArchived);

    }
}
