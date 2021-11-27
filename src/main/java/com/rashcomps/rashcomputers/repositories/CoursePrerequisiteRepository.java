/**
 * @author: ntwari egide
 * @description: school prerequisite repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.CoursePrerequisite;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePrerequisiteRepository extends JpaRepository<CoursePrerequisite, Long> {
}
