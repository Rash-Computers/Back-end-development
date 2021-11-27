/**
 * @author: ntwari egide
 * @desciption: school services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.SchoolDto;
import com.rashcomps.rashcomputers.exceptions.SchoolNotFoundException;
import com.rashcomps.rashcomputers.models.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {

    public List<School> findAll();

    public School findById(Long id) throws SchoolNotFoundException;

    public School add(SchoolDto newSchool) throws SchoolNotFoundException;

    public School update(SchoolDto updates, Long id)  throws SchoolNotFoundException;

    public Boolean delete(Long id)  throws SchoolNotFoundException;

}
