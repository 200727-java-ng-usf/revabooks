package com.revature.revabooks.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="app_users")
public class AppUser {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    // Role is an enum and cannot be mapped using @JoinColumn
//    @ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="role_id")
    @Enumerated(EnumType.STRING)
    private Role role;

    // constructors
    // no args constructors are required for Jackson to map properly!
    public AppUser() {
        super();
    }

    public AppUser(String first_name, String last_name, String username, String password, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.LOCKED;
    }

    public AppUser(String first_name, String last_name, String username, String password, String email, Role role) {
        this(first_name, last_name, username, password, email);
        this.role = role;
    }

    public AppUser(Integer id, String first_name, String last_name, String username, String password, String email, Role role) {
        this(first_name, last_name, username, password, email, role);
        this.id = id;
    }

    // copy constructor (used for conveniently copying the values of one AppUser to create a new instance with those values)
    public AppUser(AppUser copy) {
        this(copy.id, copy.first_name, copy.last_name, copy.username, copy.password, copy.email, copy.role);
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return Objects.equals(id, appUser.id) &&
                Objects.equals(first_name, appUser.first_name) &&
                Objects.equals(last_name, appUser.last_name) &&
                Objects.equals(username, appUser.username) &&
                Objects.equals(password, appUser.password) &&
                Objects.equals(email, appUser.email) &&
                role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, username, password, email, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

}
