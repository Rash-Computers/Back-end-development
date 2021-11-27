package com.rashcomps.rashcomputers.dtos;


import com.rashcomps.rashcomputers.models.GenderEnum;
import com.rashcomps.rashcomputers.models.StatusEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class SignupUserDto {
    private String firstName;

    private String secondName;

    private String username;

    private String email;

    private String firstTelPhoneNumber;

    private String secondTelPhoneNumber;

    private String profilePicturePath;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String password;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private List<IdTemplate> rolesIds;

    public SignupUserDto() {
    }

    public SignupUserDto(String username, String email, String password, StatusEnum status, List<IdTemplate> rolesIds) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.rolesIds = rolesIds;
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

    public String getFirstTelPhoneNumber() {
        return firstTelPhoneNumber;
    }

    public void setFirstTelPhoneNumber(String firstTelPhoneNumber) {
        this.firstTelPhoneNumber = firstTelPhoneNumber;
    }

    public String getSecondTelPhoneNumber() {
        return secondTelPhoneNumber;
    }

    public void setSecondTelPhoneNumber(String secondTelPhoneNumber) {
        this.secondTelPhoneNumber = secondTelPhoneNumber;
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

    public List<IdTemplate> getRolesIds() {
        return rolesIds;
    }

    public void setRolesIds(List<IdTemplate> rolesIds) {
        this.rolesIds = rolesIds;
    }

    @Override
    public String toString() {
        return "SignupUserDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstTelPhoneNumber='" + firstTelPhoneNumber + '\'' +
                ", secondTelPhoneNumber='" + secondTelPhoneNumber + '\'' +
                ", profilePicturePath='" + profilePicturePath + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", rolesIds=" + rolesIds +
                '}';
    }
}
