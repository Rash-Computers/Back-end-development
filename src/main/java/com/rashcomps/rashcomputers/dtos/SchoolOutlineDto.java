/**
 * @author: ntwari egide
 * @description: school outline dto
 */

package com.rashcomps.rashcomputers.dtos;

import com.rashcomps.rashcomputers.models.LevelEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SchoolOutlineDto {
    private String outline;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    private IdTemplate schoolId;

    public SchoolOutlineDto() {
    }

    public SchoolOutlineDto(String outline, LevelEnum level, IdTemplate schoolId) {
        this.outline = outline;
        this.level = level;
        this.schoolId = schoolId;
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

    public IdTemplate getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(IdTemplate schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "SchoolOutlineDto{" +
                "outline='" + outline + '\'' +
                ", level=" + level +
                ", schoolId=" + schoolId +
                '}';
    }
}
