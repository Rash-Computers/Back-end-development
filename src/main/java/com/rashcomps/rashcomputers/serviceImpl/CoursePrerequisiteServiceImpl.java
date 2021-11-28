/**
 * @author: ntwari egide
 * @description:  Course prerequisite service implementation
 */

package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.CoursePrerequisiteDto;
import com.rashcomps.rashcomputers.dtos.IdTemplate;
import com.rashcomps.rashcomputers.exceptions.CoursePrerequisiteNotFoundException;
import com.rashcomps.rashcomputers.models.CoursePrerequisite;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.repositories.CoursePrerequisiteRepository;
import com.rashcomps.rashcomputers.services.CoursePrerequisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursePrerequisiteServiceImpl implements CoursePrerequisiteService {

    @Autowired
    private CoursePrerequisiteRepository coursePrerequisiteRepository;

    @Autowired
    private SchoolServiceImpl schoolService;

    @Override
    public List<CoursePrerequisite> findAll() {
        return coursePrerequisiteRepository.findAll();
    }

    public CoursePrerequisite checkExistence(Long id) {

        Optional<CoursePrerequisite> coursePrerequisiteOptional = coursePrerequisiteRepository.findById(id);

        if(! coursePrerequisiteOptional.isPresent()) throw new CoursePrerequisiteNotFoundException("Prerequisite is with id: "+id+" is not found");

        return coursePrerequisiteOptional.get();

    }

    @Override
    public CoursePrerequisite findById(Long id) throws CoursePrerequisiteNotFoundException {
        return checkExistence(id);
    }

    @Override
    public CoursePrerequisite add(CoursePrerequisiteDto newPrerequisite) throws CoursePrerequisiteNotFoundException {

        List<School> schoolList = new ArrayList<>();

        for (IdTemplate idTemplate: newPrerequisite.getSchools()) {

            schoolList.add(schoolService.checkExistence(idTemplate.getIdValue()));

        }

        CoursePrerequisite coursePrerequisite = new CoursePrerequisite(
                newPrerequisite.getName(),
                newPrerequisite.getLinkUrl(),
                schoolList
        );

        return coursePrerequisiteRepository.save(coursePrerequisite);
    }

    @Override
    public CoursePrerequisite update(CoursePrerequisiteDto updates, Long id) throws CoursePrerequisiteNotFoundException {
        checkExistence(id);

        List<School> schoolList = new ArrayList<>();

        for (IdTemplate idTemplate: updates.getSchools()) {

            schoolList.add(schoolService.checkExistence(idTemplate.getIdValue()));

        }

        CoursePrerequisite coursePrerequisite = new CoursePrerequisite(
                updates.getName(),
                updates.getLinkUrl(),
                schoolList
        );

        coursePrerequisite.setId(id);

        return coursePrerequisiteRepository.save(coursePrerequisite);
    }

    @Override
    public CoursePrerequisite delete(Long id) throws CoursePrerequisiteNotFoundException {
        CoursePrerequisite coursePrerequisite = checkExistence(id);

        coursePrerequisiteRepository.deleteById(id);

        return coursePrerequisite;
    }

    @Override
    public List<CoursePrerequisite> findBySchool(Long id) throws CoursePrerequisiteNotFoundException {
        School school = schoolService.checkExistence(id);

        return coursePrerequisiteRepository.findBySchools(school);
    }
}
