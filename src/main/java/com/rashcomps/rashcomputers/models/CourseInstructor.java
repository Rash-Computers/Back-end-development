/**
 * @author: ntwari egide
 * @description: course instructoor model
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "courses_instructors_tbl")
public class CourseInstructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<User> relatedUsers;

    private String autobiography;

    @ManyToMany
    private List<School> school;

    public CourseInstructor() {
    }

    public CourseInstructor(List<User> relatedUsers, String autobiography, List<School> school) {
        this.relatedUsers = relatedUsers;
        this.autobiography = autobiography;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getRelatedUsers() {
        return relatedUsers;
    }

    public void setRelatedUsers(List<User> relatedUsers) {
        this.relatedUsers = relatedUsers;
    }

    public String getAutobiography() {
        return autobiography;
    }

    public void setAutobiography(String autobiography) {
        this.autobiography = autobiography;
    }

    public List<School> getSchool() {
        return school;
    }

    public void setSchool(List<School> school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "CourseInstructor{" +
                "id=" + id +
                ", relatedUsers=" + relatedUsers +
                ", autobiography='" + autobiography + '\'' +
                ", school=" + school +
                '}';
    }
}
