package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {
// fields/attributes
private Integer id;
private String firstName;
private String lastName;
private String username;
private String password;
private String email;
private Role role;

    public AppUser() {
        super();
    }

    public AppUser(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.LOCKED;
    }

    public String getEmail() {
        return email;
    }



    public AppUser(String firstName, String lastName, String username, String password, String email, Role role) {
        this(firstName, lastName, username, password, email);
        this.role = role;
    }

    public AppUser(Integer id, String firstName, String lastName, String username, String password,String email, Role role) {
        this(firstName, lastName, username, password, email, role);
        this.id = id;
    }

    // copy constructor (used for conveniently copying the values of one AppUser to create a new instance with those values)
    public AppUser(AppUser copy) {
        this(copy.id, copy.firstName, copy.lastName, copy.username, copy.password, copy.email, copy.role);
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    // overridden Object methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getId(), appUser.getId()) &&
                Objects.equals(getFirstName(), appUser.getFirstName()) &&
                Objects.equals(getLastName(), appUser.getLastName()) &&
                Objects.equals(getUsername(), appUser.getUsername()) &&
                Objects.equals(getPassword(), appUser.getPassword()) &&
                Objects.equals(getEmail(), appUser.getEmail()) &&
                getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(), getRole());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
