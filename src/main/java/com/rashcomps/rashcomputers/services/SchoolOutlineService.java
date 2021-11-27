/**
 * @author: ntwari egide
 * @desciption: school outline services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.SchoolOutlineDto;
import com.rashcomps.rashcomputers.exceptions.SchoolNotFoundException;
import com.rashcomps.rashcomputers.models.SchoolOutline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolOutlineService {

    public List<SchoolOutline> findAll();

    public SchoolOutline findById(Long id) throws SchoolNotFoundException;

    public SchoolOutline add(SchoolOutlineDto newSchoolOutline) throws SchoolNotFoundException;

    public SchoolOutline update(SchoolOutlineDto updates, Long id)  throws SchoolNotFoundException;

    public Boolean delete(Long id)  throws SchoolNotFoundException;

}
