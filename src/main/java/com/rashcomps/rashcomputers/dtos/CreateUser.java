package com.rashcomps.rashcomputers.dtos;

public class CreateUser {
    private String email;

    private String name;

    private String password;

    private String status;

    public CreateUser(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.status = "INACTIVE";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreateUser{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
