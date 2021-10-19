package com.rashcomps.rashcomputers.dtos;

import com.rashcomps.rashcomputers.models.Lesson;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Register lesson video dto
 */

public class RegisterLessonVideo {
    private IdTemplate relatedLesson;

    private String videoUrl;

    private Boolean isPublished;

    private Boolean isArchived;

    public RegisterLessonVideo() {
    }

    public RegisterLessonVideo(IdTemplate relatedLesson, String videoUrl, Boolean isPublished, Boolean isArchived) {
        this.relatedLesson = relatedLesson;
        this.videoUrl = videoUrl;
        this.isPublished = isPublished;
        this.isArchived = isArchived;
    }

    public IdTemplate getRelatedLesson() {
        return relatedLesson;
    }

    public void setRelatedLesson(IdTemplate relatedLesson) {
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
        return "RegisterLessonVideo{" +
                "relatedLesson=" + relatedLesson +
                ", videoUrl='" + videoUrl + '\'' +
                ", isPublished=" + isPublished +
                ", isArchived=" + isArchived +
                '}';
    }
}
