/**
 * @author: ntwari egide
 * @description: course prerequisite model
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "course_prerequisites_tbl")
public class CoursePrerequisite {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String linkUrl;

    @ManyToMany
    private List<School> schools;

    public CoursePrerequisite() {
    }

    public CoursePrerequisite(String name, String linkUrl, List<School> schools) {
        this.name = name;
        this.linkUrl = linkUrl;
        this.schools = schools;
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

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "CoursePrerequisite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", schools=" + schools +
                '}';
    }
}
