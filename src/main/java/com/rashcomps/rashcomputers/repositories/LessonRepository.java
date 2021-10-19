package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson repository
 */

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByIsPublishedAndIsArchived(Boolean isPublished, Boolean isArchived);

}
