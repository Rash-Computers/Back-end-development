/**
 * @author: ntwari egide
 * @description: school outline model
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;

@Entity
@Table( name = "school_outlines_tbl")
public class SchoolOutline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String outline;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @ManyToOne
    private School school;

    public SchoolOutline() {
    }

    public SchoolOutline(String outline, LevelEnum level, School school) {
        this.outline = outline;
        this.level = level;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "SchoolOutline{" +
                "id=" + id +
                ", outline='" + outline + '\'' +
                ", level=" + level +
                ", school=" + school +
                '}';
    }
}
