package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {
    //all have to be private for pojo design pattern
    //you can reference other types inside the same package
    //fields/ attributes
    private Integer id;
    private String firstName;
    private String LastName;
    private String userName;
    private String passWord;
    private Role role;

    //constructors
    public AppUser(){
        super();
    }

    public AppUser(String firstName, String lastName, String userName, String passWord, Role role) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public AppUser(Integer id, String firstName, String lastName, String userName, String passWord, Role role) {
        //chained constructors have to be the first line
        this(firstName, lastName, userName, passWord, role);
        this.id = id;
    }

    //copy constructor (used for conveniently copying the values of one AppUser to create a new instance with those values
    public AppUser(AppUser copy){
        this(copy.id, copy.firstName, copy.LastName, copy.userName, copy.passWord, copy.role);
    }

    //getters and setters
    //setters can give me the power to control what is set

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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(LastName, appUser.LastName) &&
                Objects.equals(userName, appUser.userName) &&
                Objects.equals(passWord, appUser.passWord) &&
                role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, LastName, userName, passWord, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role=" + role +
                '}';
    }


}
