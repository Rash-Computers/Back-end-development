package com.rashcomps.rashcomputers.models;

import javax.persistence.*;

/**
 * @author : ntwari egide - Rash Computers
 * @description: Lesson video model
 */


@Entity
@Table( name = "lesson_videos_table")
public class LessonVideo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    private Lesson relatedLesson;

    private String videoUrl;

    private Boolean isPublished;

    private Boolean isArchived;

    public LessonVideo() {
    }

    public LessonVideo(Lesson relatedLesson, String videoUrl, Boolean isPublished, Boolean isArchived) {
        this.relatedLesson = relatedLesson;
        this.videoUrl = videoUrl;
        this.isPublished = isPublished;
        this.isArchived = isArchived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lesson getRelatedLesson() {
        return relatedLesson;
    }

    public void setRelatedLesson(Lesson relatedLesson) {
        this.relatedLesson = relatedLesson;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    @Override
    public String toString() {
        return "LessonVideo{" +
                "id=" + id +
                ", relatedLesson=" + relatedLesson +
                ", videoUrl='" + videoUrl + '\'' +
                ", isPublished=" + isPublished +
                ", isArchived=" + isArchived +
                '}';
    }
}
