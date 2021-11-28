/**
 * @author: ntwari egide
 * @desciption: Course Curriculum services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.CourseCurriculumDto;
import com.rashcomps.rashcomputers.exceptions.CourseCurriculumNotFoundException;
import com.rashcomps.rashcomputers.models.CourseCurriculum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseCurriculumService {

    public List<CourseCurriculum> findAll();

    public CourseCurriculum findById(Long id) throws CourseCurriculumNotFoundException;

    public CourseCurriculum add(CourseCurriculumDto newCurriculum) throws CourseCurriculumNotFoundException;

    public CourseCurriculum update(CourseCurriculumDto updates, Long id)  throws CourseCurriculumNotFoundException;

    public CourseCurriculum delete(Long id)  throws CourseCurriculumNotFoundException;

    public List<CourseCurriculum> findBySchool(Long schoolId)  throws CourseCurriculumNotFoundException;

}
