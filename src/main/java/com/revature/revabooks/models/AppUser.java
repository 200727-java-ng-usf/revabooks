package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {
    //fieldds/attributes
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private Role role;

    //constructors
    public AppUser(){
        super();
    }
    //create user with no id
    public AppUser(String firstName, String lastName, String userName, String passWord, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public AppUser(Integer id, String firstName, String lastName, String userName, String passWord, Role role) {
        this(firstName, lastName, userName, passWord, role);
        this.id = id;
    }

    //copy constructor (used for conveniently copying the fields of one instance into another instance)
    public AppUser(AppUser copy){
        this(copy.id, copy.firstName, copy.lastName, copy.userName, copy.passWord, copy.role);
    }

    //getters and setters

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getRole() {

        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //any other instance methods

    //overridden methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getId(), appUser.getId()) &&
                Objects.equals(getFirstName(), appUser.getFirstName()) &&
                Objects.equals(getLastName(), appUser.getLastName()) &&
                Objects.equals(getUserName(), appUser.getUserName()) &&
                Objects.equals(getPassWord(), appUser.getPassWord()) &&
                getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUserName(), getPassWord(), getRole());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role=" + role +
                '}';
    }
}
