/**
 * @author: ntwari egide
 * @desciption: school services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.CoursePrerequisiteDto;
import com.rashcomps.rashcomputers.exceptions.CoursePrerequisiteNotFoundException;
import com.rashcomps.rashcomputers.models.CoursePrerequisite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoursePrerequisiteService {

    public List<CoursePrerequisite> findAll();

    public CoursePrerequisite findById(Long id) throws CoursePrerequisiteNotFoundException;

    public CoursePrerequisite add(CoursePrerequisiteDto newPrerequisite) throws CoursePrerequisiteNotFoundException;

    public CoursePrerequisite update(CoursePrerequisiteDto updates, Long id)  throws CoursePrerequisiteNotFoundException;

    public CoursePrerequisite delete(Long id)  throws CoursePrerequisiteNotFoundException;

    public List<CoursePrerequisite> findBySchool(Long id)  throws CoursePrerequisiteNotFoundException;

}
