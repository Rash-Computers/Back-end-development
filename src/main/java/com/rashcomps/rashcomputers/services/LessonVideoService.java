/**
 * @author: ntwari egide
 * @desciption: lesson video services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.LessonVideoDto;
import com.rashcomps.rashcomputers.exceptions.LessonVideoNotFoundException;
import com.rashcomps.rashcomputers.models.LessonVideo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonVideoService {

    public List<LessonVideo> findAll();

    public LessonVideo findById(Long id) throws LessonVideoNotFoundException;

    public LessonVideo add(LessonVideoDto newVideo) throws LessonVideoNotFoundException;

    public LessonVideo update(LessonVideoDto updates, Long id)  throws LessonVideoNotFoundException;

    public LessonVideo delete(Long id)  throws LessonVideoNotFoundException;

    public LessonVideo findBySchoolOutline(Long schoolOutlineId)  throws LessonVideoNotFoundException;

}
