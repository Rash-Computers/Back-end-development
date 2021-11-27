package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.CourseInstructorDto;
import com.rashcomps.rashcomputers.dtos.IdTemplate;
import com.rashcomps.rashcomputers.exceptions.CourseInstructorNotFoundException;
import com.rashcomps.rashcomputers.models.CourseInstructor;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.repositories.CourseInstructorRepository;
import com.rashcomps.rashcomputers.services.CourseInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseInstructorServiceImpl implements CourseInstructorService {

    @Autowired
    private CourseInstructorRepository courseInstructorRepository;

    @Autowired
    private SchoolServiceImpl schoolService;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<CourseInstructor> findAll() {
        return courseInstructorRepository.findAll();
    }

    public CourseInstructor checkExistence(Long id) {

        Optional<CourseInstructor> courseInstructorOptional = courseInstructorRepository.findById(id);

        if(! courseInstructorOptional.isPresent()) throw new CourseInstructorNotFoundException("Instructor with id: "+id+" is not found");

        return courseInstructorOptional.get();

    }

    @Override
    public CourseInstructor findById(Long id) throws CourseInstructorNotFoundException {
        return checkExistence(id);
    }

    @Override
    public CourseInstructor add(CourseInstructorDto newInstructor) throws CourseInstructorNotFoundException {

        List<School> schoolList = new ArrayList<>();

        for (IdTemplate idTemplate: newInstructor.getSchool()) {

            schoolList.add(schoolService.checkExistence(idTemplate.getIdValue()));

        }

        List<User> relatedUsers = new ArrayList<>();

        for (IdTemplate idTemplate: newInstructor.getRelatedUsers()) {

            relatedUsers.add(userService.checkExistence(idTemplate.getIdValue()));

        }


        CourseInstructor instructor = new CourseInstructor(
                relatedUsers,
                newInstructor.getAutobiography(),
                schoolList
        );

        return courseInstructorRepository.save(instructor);
    }

    @Override
    public CourseInstructor update(CourseInstructorDto updates, Long id) throws CourseInstructorNotFoundException {

        checkExistence(id);

        List<School> schoolList = new ArrayList<>();

        for (IdTemplate idTemplate: updates.getSchool()) {

            schoolList.add(schoolService.checkExistence(idTemplate.getIdValue()));

        }

        List<User> relatedUsers = new ArrayList<>();

        for (IdTemplate idTemplate: updates.getRelatedUsers()) {

            relatedUsers.add(userService.checkExistence(idTemplate.getIdValue()));

        }


        CourseInstructor instructor = new CourseInstructor(
                relatedUsers,
                updates.getAutobiography(),
                schoolList
        );

        instructor.setId(id);

        return courseInstructorRepository.save(instructor);
    }

    @Override
    public CourseInstructor delete(Long id) throws CourseInstructorNotFoundException {

        CourseInstructor courseInstructor = checkExistence(id);

        courseInstructorRepository.deleteById(id);

        return courseInstructor;
    }
}
