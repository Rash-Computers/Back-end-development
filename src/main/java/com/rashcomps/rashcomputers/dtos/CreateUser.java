package com.rashcomps.rashcomputers.dtos;

import java.util.List;

public class CreateUser {

    private String firstName;

    private String secondName;

    private String username;

    private String email;

    private String firstTelPhoneNumber;

    private String secondTelPhoneNumber;

    private String profilePicturePath;

    private String gender;

    private String password;

    private String status;

    private List<IdTemplate> roles;


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

    public CreateUser() {
    }

    public CreateUser(String firstName, String secondName, String username, String email, String firstTelPhoneNumber, String secondTelPhoneNumber, String profilePicturePath, String gender, String password, String status, List<IdTemplate> roles) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.email = email;
        this.firstTelPhoneNumber = firstTelPhoneNumber;
        this.secondTelPhoneNumber = secondTelPhoneNumber;
        this.profilePicturePath = profilePicturePath;
        this.gender = gender;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public List<IdTemplate> getRoles() {
        return roles;
    }

    public void setRoles(List<IdTemplate> roles) {
        this.roles = roles;
    }
}
