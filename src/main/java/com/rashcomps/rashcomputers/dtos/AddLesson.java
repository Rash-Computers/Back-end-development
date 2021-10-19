package com.rashcomps.rashcomputers.dtos;

import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Create Lesson dto
 */

public class AddLesson {

    private String name;

    private String contents;

    private List<IdTemplate> lessonCategory;

    private String coverImageUrl;


    private Boolean isPublished;

    private Boolean isArchived;

    public AddLesson() {
    }

    public AddLesson(String name, String contents, List<IdTemplate> lessonCategory, String coverImageUrl, Boolean isPublished, Boolean isArchived) {
        this.name = name;
        this.contents = contents;
        this.lessonCategory = lessonCategory;
        this.coverImageUrl = coverImageUrl;
        this.isPublished = isPublished;
        this.isArchived = isArchived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public List<IdTemplate> getLessonCategory() {
        return lessonCategory;
    }

    public void setLessonCategory(List<IdTemplate> lessonCategory) {
        this.lessonCategory = lessonCategory;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
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
        return "AddLesson{" +
                "name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                ", lessonCategory=" + lessonCategory +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", isPublished=" + isPublished +
                ", isArchived=" + isArchived +
                '}';
    }
}
