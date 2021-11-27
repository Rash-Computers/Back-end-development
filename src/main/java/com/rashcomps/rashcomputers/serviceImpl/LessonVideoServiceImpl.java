package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.IdTemplate;
import com.rashcomps.rashcomputers.dtos.LessonVideoDto;
import com.rashcomps.rashcomputers.exceptions.LessonVideoNotFoundException;
import com.rashcomps.rashcomputers.models.LessonVideo;
import com.rashcomps.rashcomputers.models.SchoolOutline;
import com.rashcomps.rashcomputers.repositories.LessonVideoRepository;
import com.rashcomps.rashcomputers.services.LessonVideoService;
/**
 * @author: ntwari egide
 * @description:  lesson video service implementation
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonVideoServiceImpl implements LessonVideoService {

    @Autowired
    private LessonVideoRepository lessonVideoRepository;

    @Autowired
    private SchoolOutlineServiceImpl schoolOutlineService;

    @Override
    public List<LessonVideo> findAll() {
        return lessonVideoRepository.findAll();
    }

    public LessonVideo checkExistence(Long id) {

        Optional<LessonVideo> lessonVideoOptional = lessonVideoRepository.findById(id);

        if(! lessonVideoOptional.isPresent()) throw new LessonVideoNotFoundException("Lesson video with id:"+id+" is not found");

        return lessonVideoOptional.get();
    }

    @Override
    public LessonVideo findById(Long id) throws LessonVideoNotFoundException {
        return checkExistence(id);
    }

    @Override
    public LessonVideo add(LessonVideoDto newVideo) throws LessonVideoNotFoundException {

        List<SchoolOutline> schoolOutlines = new ArrayList<>();

        for (IdTemplate idTemplate: newVideo.getRelatedSchoolOutlineIds()) {

            schoolOutlines.add(schoolOutlineService.checkExistence(idTemplate.getIdValue()));

        }

        LessonVideo lessonVideo = new LessonVideo(
                schoolOutlines,
                newVideo.getVideoUrl(),
                newVideo.getPublished(),
                newVideo.getArchived()
        );

        return lessonVideoRepository.save(lessonVideo);
    }

    @Override
    public LessonVideo update(LessonVideoDto updates, Long id) throws LessonVideoNotFoundException {
        checkExistence(id);

        List<SchoolOutline> schoolOutlines = new ArrayList<>();

        for (IdTemplate idTemplate: updates.getRelatedSchoolOutlineIds()) {

            schoolOutlines.add(schoolOutlineService.checkExistence(idTemplate.getIdValue()));

        }

        LessonVideo lessonVideo = new LessonVideo(
                schoolOutlines,
                updates.getVideoUrl(),
                updates.getPublished(),
                updates.getArchived()
        );

        lessonVideo.setId(id);

        return lessonVideoRepository.save(lessonVideo);
    }

    @Override
    public LessonVideo delete(Long id) throws LessonVideoNotFoundException {

        LessonVideo lessonVideoFound =  checkExistence(id);

        lessonVideoRepository.deleteById(id);

        return lessonVideoFound;
    }
}
