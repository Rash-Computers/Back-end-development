/**
 * @author: ntwari egide
 * @description: lesson video repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.LessonVideo;
import com.rashcomps.rashcomputers.models.SchoolOutline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonVideoRepository extends JpaRepository<LessonVideo, Long> {
    LessonVideo findByRelatedSchoolOutline(SchoolOutline id);
}
