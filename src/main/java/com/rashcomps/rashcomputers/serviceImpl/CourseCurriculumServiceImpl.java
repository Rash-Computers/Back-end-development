/**
 * @author: ntwari egide
 * @description:  Course curriculum service implementation
 */


package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.CourseCurriculumDto;
import com.rashcomps.rashcomputers.exceptions.CourseCurriculumNotFoundException;
import com.rashcomps.rashcomputers.models.CourseCurriculum;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.repositories.CourseCurriculumRepository;
import com.rashcomps.rashcomputers.services.CourseCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseCurriculumServiceImpl implements CourseCurriculumService {

    @Autowired
    private CourseCurriculumRepository courseCurriculumRepository;

    @Autowired
    private SchoolServiceImpl schoolService;

    @Override
    public List<CourseCurriculum> findAll() {
        return courseCurriculumRepository.findAll();
    }

    public CourseCurriculum checkExistence(Long id) {

        Optional<CourseCurriculum> courseCurriculumOptional = courseCurriculumRepository.findById(id);

        if(! courseCurriculumOptional.isPresent()) throw new CourseCurriculumNotFoundException("Curriculum with id "+id+" is not found");

        return courseCurriculumOptional.get();

    }

    @Override
    public CourseCurriculum findById(Long id) throws CourseCurriculumNotFoundException {
        return checkExistence(id);
    }

    @Override
    public CourseCurriculum add(CourseCurriculumDto newCurriculum) throws CourseCurriculumNotFoundException {

        School school = schoolService.checkExistence(newCurriculum.getSchool().getIdValue());

        CourseCurriculum courseCurriculum = new CourseCurriculum(
                newCurriculum.getName(),
                newCurriculum.getCurriculumFileUrl(),
                school
        );

        return courseCurriculumRepository.save(courseCurriculum);
    }

    @Override
    public CourseCurriculum update(CourseCurriculumDto updates, Long id) throws CourseCurriculumNotFoundException {
        checkExistence(id);

        School school = schoolService.checkExistence(updates.getSchool().getIdValue());

        CourseCurriculum courseCurriculum = new CourseCurriculum(
                updates.getName(),
                updates.getCurriculumFileUrl(),
                school
        );

        courseCurriculum.setId(id);

        return courseCurriculumRepository.save(courseCurriculum);
    }

    @Override
    public CourseCurriculum delete(Long id) throws CourseCurriculumNotFoundException {

        CourseCurriculum courseCurriculum = checkExistence(id);

        courseCurriculumRepository.deleteById(id);

        return courseCurriculum;
    }
}
