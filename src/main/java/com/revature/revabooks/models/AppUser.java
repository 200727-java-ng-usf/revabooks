package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {

    // POJO's layers

    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    /* Constructors */
    public AppUser(Integer id, String firstName, String lastName, String userName, String password, Role role) {
        this(firstName, lastName, userName, password, role);
        this.id = id;

    }

    public AppUser(String firstName, String lastName, String userName, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    /* A copy constructor (used for conveniently copying the valuse of one AppUser*/
    public AppUser(AppUser copy){
        this(copy.id, copy.firstName, copy.lastName, copy.userName, copy.password, copy.role);
    }
    public AppUser(){
        super();
    }
    // Getters and Setters
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
    // Overridden Object Methods
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
                Objects.equals(role, appUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
