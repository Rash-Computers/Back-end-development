/**
 * @author: ntwari egide
 * @description: course instructor dto
 */

package com.rashcomps.rashcomputers.dtos;


import java.util.List;

public class CourseInstructorDto {

    private List<IdTemplate> relatedUsers;

    private String autobiography;

    private List<IdTemplate> school;

    public CourseInstructorDto() {
    }

    public CourseInstructorDto(List<IdTemplate> relatedUsers, String autobiography, List<IdTemplate> school) {
        this.relatedUsers = relatedUsers;
        this.autobiography = autobiography;
        this.school = school;
    }

    public List<IdTemplate> getRelatedUsers() {
        return relatedUsers;
    }

    public void setRelatedUsers(List<IdTemplate> relatedUsers) {
        this.relatedUsers = relatedUsers;
    }

    public String getAutobiography() {
        return autobiography;
    }

    public void setAutobiography(String autobiography) {
        this.autobiography = autobiography;
    }

    public List<IdTemplate> getSchool() {
        return school;
    }

    public void setSchool(List<IdTemplate> school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "CourseInstructorDto{" +
                "relatedUsers=" + relatedUsers +
                ", autobiography='" + autobiography + '\'' +
                ", school=" + school +
                '}';
    }
}
