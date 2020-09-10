package com.revature.revabooks.dtos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.Objects;

public class Principle {
    private int id;
    private String username;
    private String role;

    public Principle() {
        super();
    }

    public Principle(AppUser user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = (user.getRole()).toString();
    }

    public String stringify() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Principle)) return false;
        Principle principle = (Principle) o;
        return getId() == principle.getId() &&
                Objects.equals(getUsername(), principle.getUsername()) &&
                Objects.equals(getRole(), principle.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRole());
    }

    @Override
    public String toString() {
        return "Principle{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
