package com.revature.model;

import java.util.Objects;

public class User {

    private int userId;
    private String username;
    private String firstName;
    private String lastName;
    private String company;
    private String userPassword;
    private String positionRole;

    public User(int userId, String username, String firstName, String lastName, String company, String userPassword, String positionRole) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.userPassword = userPassword;
        this.positionRole = positionRole;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPositionRole() {
        return positionRole;
    }

    public void setPositionRole(String positionRole) {
        this.positionRole = positionRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(username, user.username) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(company, user.company) && Objects.equals(userPassword, user.userPassword) && Objects.equals(positionRole, user.positionRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, firstName, lastName, company, userPassword, positionRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", positionRole='" + positionRole + '\'' +
                '}';
    }
}
