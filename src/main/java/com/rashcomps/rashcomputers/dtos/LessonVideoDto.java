/**
 * @author: ntwari egide
 * @description: course video dto
 */

package com.rashcomps.rashcomputers.dtos;


import java.util.List;

public class LessonVideoDto {
    private List<IdTemplate> relatedSchoolOutlineIds;

    private String videoUrl;

    private Boolean isPublished;

    private Boolean isArchived;

    public LessonVideoDto() {
    }

    public LessonVideoDto(List<IdTemplate> relatedSchoolOutlineIds, String videoUrl, Boolean isPublished, Boolean isArchived) {
        this.relatedSchoolOutlineIds = relatedSchoolOutlineIds;
        this.videoUrl = videoUrl;
        this.isPublished = isPublished;
        this.isArchived = isArchived;
    }

    public List<IdTemplate> getRelatedSchoolOutlineIds() {
        return relatedSchoolOutlineIds;
    }

    public void setRelatedSchoolOutlineIds(List<IdTemplate> relatedSchoolOutlineIds) {
        this.relatedSchoolOutlineIds = relatedSchoolOutlineIds;
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
        return "LessonVideoDto{" +
                "relatedSchoolOutlineIds=" + relatedSchoolOutlineIds +
                ", videoUrl='" + videoUrl + '\'' +
                ", isPublished=" + isPublished +
                ", isArchived=" + isArchived +
                '}';
    }
}
