/**
 * @author: ntwari egide
 * @description: User modal
 */

/**
 * first name
 * second name
 * username
 * email
 * profile pic url
 * associated project
 * status
 * tel number 1
 * tel number 2
 * gender
 * roles
 */

package com.rashcomps.rashcomputers.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    private String username;

    private String email;


    private String profilePicturePath;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

//    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToMany()
    private List<Role> roles;

    public User(){}

    public User(String username, String email, String password, StatusEnum status, List<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = GenderEnum.NOT_SET;
        this.status = status;
        this.roles = roles;
    }

    public User(String firstName, String secondName, String username, String email, String profilePicturePath, GenderEnum gender, String password, StatusEnum status, List<Role> roles) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\''+
                ", profilePicturePath='" + profilePicturePath + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }
}