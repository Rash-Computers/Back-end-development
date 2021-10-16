package com.rashcomps.rashcomputers.dtos;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Update Lesson Category dto
 */
public class UpdateCategoryLesson {
    private String name;

    private String description;

    private String coverImageUrl;

    public UpdateCategoryLesson(String name, String description, String coverImageUrl) {
        this.name = name;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "UpdateLesson{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                '}';
    }
}
