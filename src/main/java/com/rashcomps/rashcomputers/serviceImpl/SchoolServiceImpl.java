/**
 * @author: ntwari egide
 * @description:  school service implementation
 */

package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.SchoolDto;
import com.rashcomps.rashcomputers.exceptions.SchoolNotFoundException;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.repositories.SchoolRepository;
import com.rashcomps.rashcomputers.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public School checkExistence(Long id) {

        Optional<School> schoolOptional = schoolRepository.findById(id);

        if(! schoolOptional.isPresent()) throw new SchoolNotFoundException("School with : "+id+" is not found");

        return schoolOptional.get();

    }

    @Override
    public School findById(Long id) throws SchoolNotFoundException {
        return checkExistence(id);
    }

    @Override
    public School add(SchoolDto newSchool) throws SchoolNotFoundException {

        School school = new School(
                newSchool.getSchoolName(),
                newSchool.getDescription(),
                newSchool.getCoverImageUrl(),
                newSchool.getPublished(),
                newSchool.getArchived()
        );

        return schoolRepository.save(school);
    }

    @Override
    public School update(SchoolDto updates, Long id) throws SchoolNotFoundException {

        checkExistence(id);

        School school = new School(
                updates.getSchoolName(),
                updates.getDescription(),
                updates.getCoverImageUrl(),
                updates.getPublished(),
                updates.getArchived()
        );

        school.setId(id);

        return schoolRepository.save(school);
    }

    @Override
    public Boolean delete(Long id) throws SchoolNotFoundException {

        checkExistence(id);

        schoolRepository.deleteById(id);

        return true;
    }
}
