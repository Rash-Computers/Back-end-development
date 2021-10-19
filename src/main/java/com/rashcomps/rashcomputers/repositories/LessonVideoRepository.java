package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson video repository
 */


@Repository
public interface LessonVideoRepository extends JpaRepository<LessonVideo,Long> {
    List<LessonVideo> findByIsArchivedAndIsPublished(Boolean isArchived, Boolean isPublished);
}