/**
 * @author: ntwari egide
 * @desciption: Course instructor services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.CourseInstructorDto;
import com.rashcomps.rashcomputers.exceptions.CourseInstructorNotFoundException;
import com.rashcomps.rashcomputers.models.CourseInstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseInstructorService {

    public List<CourseInstructor> findAll();

    public CourseInstructor findById(Long id) throws CourseInstructorNotFoundException;

    public CourseInstructor add(CourseInstructorDto newInstructor) throws CourseInstructorNotFoundException;

    public CourseInstructor update(CourseInstructorDto updates, Long id)  throws CourseInstructorNotFoundException;

    public CourseInstructor delete(Long id)  throws CourseInstructorNotFoundException;

}
