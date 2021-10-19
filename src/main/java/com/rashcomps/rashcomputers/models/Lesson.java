package com.rashcomps.rashcomputers.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author : ntwari egide - Rash Computers
 * @description: lesson model
 */


@Entity
@Table( name = "lessons_table")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contents;

    @ManyToMany
    private List<LessonCategory> lessonCategory;

   private String coverImageUrl;


    private Boolean isPublished;

    private Boolean isArchived;

    public Lesson() {
    }

    public Lesson(String name, String contents, List<LessonCategory> lessonCategory, String coverImageUrl, Boolean isPublished, Boolean isArchived) {
        this.name = name;
        this.contents = contents;
        this.lessonCategory = lessonCategory;
        this.coverImageUrl = coverImageUrl;
        this.isPublished = isPublished;
        this.isArchived = isArchived;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<LessonCategory> getLessonCategory() {
        return lessonCategory;
    }

    public void setLessonCategory(List<LessonCategory> lessonCategory) {
        this.lessonCategory = lessonCategory;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                ", lessonCategory=" + lessonCategory +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                '}';
    }
}
