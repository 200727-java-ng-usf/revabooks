package com.revature.revbooks.models;

import java.util.Objects;

public class AppUser {


   // fields
   private Integer id;
   private String firstname;
   private String lastname;
   private String username;
   private String password;
   private Role role;

    public AppUser() {
    }

    // constructor with no id because id does not exist when you sign up
    public AppUser(String firstname, String lastname, String username, String password, Role role) {

        this(firstname, lastname, username, password);
        this.role = role;
    }

    // constructor for register
    public AppUser(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = Role.LOCKED;
    }

    public AppUser(Integer id, String firstname, String lastname, String username, String password, Role role) {
        this(firstname, lastname, username, password, role); // easy way to rewrite the code just call
        this.role = role;
    }

    // copy constructor
    public AppUser(AppUser copy){
        this(copy.firstname, copy.lastname, copy.username, copy.password, copy.role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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


    //override method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getId(), appUser.getId()) &&
                Objects.equals(getFirstname(), appUser.getFirstname()) &&
                Objects.equals(getLastname(), appUser.getLastname()) &&
                Objects.equals(getUsername(), appUser.getUsername()) &&
                Objects.equals(getPassword(), appUser.getPassword()) &&
                getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname(), getUsername(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
