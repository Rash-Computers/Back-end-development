/**
 * @author: ntwari egide
 * @description: lesson video model
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "lessons_videos_tbl")

public class LessonVideo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<SchoolOutline> relatedSchoolOutline;

    private String videoUrl;

    private Boolean isPublished;

    private Boolean isArchived;

    public LessonVideo() {
    }

    public LessonVideo(List<SchoolOutline> relatedSchoolOutline, String videoUrl, Boolean isPublished, Boolean isArchived) {
        this.relatedSchoolOutline = relatedSchoolOutline;
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

    public List<SchoolOutline> getRelatedSchoolOutline() {
        return relatedSchoolOutline;
    }

    public void setRelatedSchoolOutline(List<SchoolOutline> relatedSchoolOutline) {
        this.relatedSchoolOutline = relatedSchoolOutline;
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
                ", relatedSchoolOutline=" + relatedSchoolOutline +
                ", videoUrl='" + videoUrl + '\'' +
                ", isPublished=" + isPublished +
                ", isArchived=" + isArchived +
                '}';
    }
}
