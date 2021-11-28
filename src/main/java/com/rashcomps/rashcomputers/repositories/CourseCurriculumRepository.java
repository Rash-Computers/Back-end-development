/**
 * @author: ntwari egide
 * @description: course curriculum repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.CourseCurriculum;
import com.rashcomps.rashcomputers.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCurriculumRepository extends JpaRepository<CourseCurriculum, Long> {
    List<CourseCurriculum> findBySchool(School school);
}
