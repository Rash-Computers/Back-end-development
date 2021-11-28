/**
 * @author: ntwari egide
 * @description: school prerequisite repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.CoursePrerequisite;;
import com.rashcomps.rashcomputers.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursePrerequisiteRepository extends JpaRepository<CoursePrerequisite, Long> {
    List<CoursePrerequisite> findBySchools(School school);
}
