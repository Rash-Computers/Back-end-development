/**
 * @author: ntwari egide
 * @description: school model
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;

@Entity
@Table(name = "schools_tbl")

public class School {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;

    private String description;

    private String coverImageUrl;

    private Boolean isPublished;

    private Boolean isArchived;

    public School() {
    }

    public School(String schoolName, String description, String coverImageUrl, Boolean isPublished, Boolean isArchived) {
        this.schoolName = schoolName;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.isPublished = isPublished;
        this.isArchived = isArchived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", isPublished=" + isPublished +
                ", isArchived=" + isArchived +
                '}';
    }
}
