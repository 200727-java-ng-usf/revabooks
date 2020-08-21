package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {

    // Set up fields
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private Role role;

    public AppUser(){}

    public AppUser(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = Role.LOCKED;
    }

    public AppUser(String firstName, String lastName, String userName, String password, String email, Role role) {
        this(firstName, lastName, userName, password, email);
        this.role = role;
    }

    public AppUser(Integer id, String firstName, String lastName, String userName, String password, String email, Role role) {
        this(firstName, lastName, userName, password, email, role);
        this.id = id;
    }

    public AppUser(AppUser copy) {
        this(copy.id, copy.firstName, copy.lastName, copy.userName, copy.password, copy.email, copy.role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(userName, appUser.userName) &&
                Objects.equals(password, appUser.password) &&
                Objects.equals(email, appUser.email) &&
                role == appUser.role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, email, role);
    }
}
