/**
 * @author: ntwari egide
 * @description: course curriculum dto
 */
package com.rashcomps.rashcomputers.dtos;

public class CourseCurriculumDto {
    private String name;

    private String curriculumFileUrl;

    private IdTemplate school;

    public CourseCurriculumDto() {
    }

    public CourseCurriculumDto(String name, String curriculumFileUrl, IdTemplate school) {
        this.name = name;
        this.curriculumFileUrl = curriculumFileUrl;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurriculumFileUrl() {
        return curriculumFileUrl;
    }

    public void setCurriculumFileUrl(String curriculumFileUrl) {
        this.curriculumFileUrl = curriculumFileUrl;
    }

    public IdTemplate getSchool() {
        return school;
    }

    public void setSchool(IdTemplate school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "CourseCurriculumDto{" +
                "name='" + name + '\'' +
                ", curriculumFileUrl='" + curriculumFileUrl + '\'' +
                ", school=" + school +
                '}';
    }
}
