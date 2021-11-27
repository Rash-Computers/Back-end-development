/**
 * @author: ntwari egide
 * @description: course curriculum repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.CourseCurriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCurriculumRepository extends JpaRepository<CourseCurriculum, Long> {
}
