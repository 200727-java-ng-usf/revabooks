package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {
    private Integer id;
    private String FirstName;
    private String LastName;
    private String username;
    private String password;
    private Role role;


    public AppUser() {
        super();
    }

    public AppUser(String firstName, String lastName, String username, String password, Role role) {

        FirstName = firstName;
        LastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //constructor chaining
    public AppUser(Integer id, String firstName, String lastName, String username, String password, Role role) {
        this(firstName, lastName, username, password, role);
        this.id = id;

    }

    //copy constructor
    public AppUser(AppUser copy) {
        this(copy.id, copy.FirstName, copy.LastName, copy.username, copy.password, copy.role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
                getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
