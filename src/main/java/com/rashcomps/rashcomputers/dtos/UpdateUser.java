/**
 * @author: ntwari egide
 * @description: update user dto
 */

package com.rashcomps.rashcomputers.dtos;


import com.rashcomps.rashcomputers.models.GenderEnum;
import com.rashcomps.rashcomputers.models.StatusEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class UpdateUser {
    private String firstName;

    private String secondName;

    private String username;

    private String email;

    private String profilePicturePath;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String password;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private List<IdTemplate> roles;


    public UpdateUser() {
    }

    public UpdateUser(String firstName, String secondName, String username, String email, String profilePicturePath, GenderEnum gender, String password, StatusEnum status, List<IdTemplate> roles) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.email = email;
        this.profilePicturePath = profilePicturePath;
        this.gender = gender;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<IdTemplate> getRoles() {
        return roles;
    }

    public void setRoles(List<IdTemplate> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UpdateUser{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profilePicturePath='" + profilePicturePath + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }
}