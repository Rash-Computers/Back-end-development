/**
 * @author: ntwari egide
 * @description: course instructor repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.CourseInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInstructorRepository extends JpaRepository<CourseInstructor, Long> {
}
