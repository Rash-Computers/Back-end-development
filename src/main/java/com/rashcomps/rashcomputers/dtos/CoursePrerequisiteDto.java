/**
 * @author: ntwari egide
 * @description: course prerequisite dto
 */

package com.rashcomps.rashcomputers.dtos;

import java.util.List;

public class CoursePrerequisiteDto {
    private String name;

    private String linkUrl;

    private List<IdTemplate> schools;

    public CoursePrerequisiteDto() {
    }

    public CoursePrerequisiteDto(String name, String linkUrl, List<IdTemplate> schools) {
        this.name = name;
        this.linkUrl = linkUrl;
        this.schools = schools;
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

    public List<IdTemplate> getSchools() {
        return schools;
    }

    public void setSchools(List<IdTemplate> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "CoursePrerequisiteDto{" +
                "name='" + name + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", schools=" + schools +
                '}';
    }
}
