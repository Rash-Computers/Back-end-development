/**
 * @author: ntwari egide
 * @description:  school outline service implementation
 */

package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.SchoolOutlineDto;
import com.rashcomps.rashcomputers.exceptions.SchoolNotFoundException;
import com.rashcomps.rashcomputers.exceptions.SchoolOutlineNotFoundException;
import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.models.SchoolOutline;
import com.rashcomps.rashcomputers.repositories.SchoolOutlineRepository;
import com.rashcomps.rashcomputers.services.SchoolOutlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolOutlineServiceImpl  implements SchoolOutlineService {

    @Autowired
    private SchoolOutlineRepository schoolOutlineRepository;

    @Autowired
    private SchoolServiceImpl schoolService;

    @Override
    public List<SchoolOutline> findAll() {
        return schoolOutlineRepository.findAll();
    }

    public SchoolOutline checkExistence(Long id) {

        Optional<SchoolOutline> schoolOutlineOptional = schoolOutlineRepository.findById(id);

        if(! schoolOutlineOptional.isPresent()) throw new SchoolOutlineNotFoundException("School outline with id: "+id+" is not found");

        return schoolOutlineOptional.get();

    }

    @Override
    public SchoolOutline findById(Long id) throws SchoolNotFoundException {
        return checkExistence(id);
    }

    @Override
    public SchoolOutline add(SchoolOutlineDto newSchoolOutline) throws SchoolNotFoundException {

        School school = schoolService.checkExistence(newSchoolOutline.getSchoolId().getIdValue());

        SchoolOutline schoolOutline = new SchoolOutline(
                newSchoolOutline.getOutline(),
                newSchoolOutline.getLevel(),
                school
        );

        return schoolOutlineRepository.save(schoolOutline);
    }

    @Override
    public SchoolOutline update(SchoolOutlineDto updates, Long id) throws SchoolNotFoundException {

        checkExistence(id);

        School school = schoolService.checkExistence(updates.getSchoolId().getIdValue());

        SchoolOutline schoolOutline = new SchoolOutline(
                updates.getOutline(),
                updates.getLevel(),
                school
        );

        return schoolOutlineRepository.save(schoolOutline);
    }

    @Override
    public Boolean delete(Long id) throws SchoolNotFoundException {
        checkExistence(id);

        schoolOutlineRepository.deleteById(id);

        return true;
    }
}
