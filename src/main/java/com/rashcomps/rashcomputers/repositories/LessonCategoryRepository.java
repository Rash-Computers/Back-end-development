package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.LessonCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Create Lesson Category repository
 */

public interface LessonCategoryRepository extends JpaRepository<LessonCategory,Long> {

    List<LessonCategory> findByIsPublishedAndIsArchived(Boolean isPublished, Boolean isArchived);

}
