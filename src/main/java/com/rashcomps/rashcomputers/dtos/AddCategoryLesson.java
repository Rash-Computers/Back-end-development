package com.rashcomps.rashcomputers.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Create Lesson Category dto
 */
public class AddCategoryLesson {

    @NotBlank(message =  "Lesson category name is required")
    @Max(value = 255,message = "Lesson category name should not be above 255 characters")
    @Min(value = 2, message = "Lesson category name should not be below 2 characters")
    private String name;

    @NotBlank(message =  "Lesson category description is required")
    @Max(value = 255,message = "Lesson category description should not be above 255 characters")
    @Min(value = 2, message = "Lesson category description should not be below 2 characters")
    private String description;

    @NotBlank(message =  "Lesson category cover image is required")
    private String coverImageUrl;

    public AddCategoryLesson(String name, String description, String coverImageUrl) {
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
        return "AddLesson{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                '}';
    }
}
