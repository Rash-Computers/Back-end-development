/**
 * @author: ntwari egide
 * @description: level enum
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;

@Entity
@Table( name = "course_curriculums_tlb")
public class CourseCurriculum {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String curriculumFileUrl;

    @ManyToOne
    private School school;

    public CourseCurriculum() {
    }

    public CourseCurriculum(String name, String curriculumFileUrl, School school) {
        this.name = name;
        this.curriculumFileUrl = curriculumFileUrl;
        this.school = school;
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

    public String getCurriculumFileUrl() {
        return curriculumFileUrl;
    }

    public void setCurriculumFileUrl(String curriculumFileUrl) {
        this.curriculumFileUrl = curriculumFileUrl;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "CourseCurriculum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", curriculumFileUrl='" + curriculumFileUrl + '\'' +
                ", school=" + school +
                '}';
    }
}
