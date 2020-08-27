package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {
	//region fields/attributes
	private Integer id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private Role role;
	//endregion

	//region Constructors
	// no-args contructors are required for jackson to map properly
	public AppUser() {
		super();
	}

	public AppUser(String firstname, String lastName, String userName, String password, String email){
		this.firstname = firstname;
		this.lastname = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.role = Role.LOCKED;
	}

	public AppUser(String firstname, String lastName, String userName, String password, String email, Role role) {
		this(firstname, lastName, userName, password, email);
		this.role = role;
	}

	public AppUser(Integer id, String firstname, String lastName, String userName, String password, String email, Role role) {
		this(firstname, lastName, userName, password, email, role);
		this.id = id;
	}

	//copy constructor (used for convbeniently copying the values of one AppUser to create a new instance with the same values.
	public AppUser(AppUser copy){
		this(copy.id, copy.firstname, copy.lastname, copy.username, copy.password, copy.email, copy.role);
	}

	//endregion

	//region Getters And Setters
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
//		if(role == null){
//			this.role = Role.LOCKED;
//		}
		this.role = role;
	}
	//endregion

	//region Methods
	//endregion

	//region Overridden Methods

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppUser appUser = (AppUser) o;
		return Objects.equals(id, appUser.id) &&
				Objects.equals(firstname, appUser.firstname) &&
				Objects.equals(lastname, appUser.lastname) &&
				Objects.equals(username, appUser.username) &&
				Objects.equals(password, appUser.password) &&
				Objects.equals(email, appUser.email) &&
				role == appUser.role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstname, lastname, username, password, email, role);
	}

	@Override
	public String toString() {
		return "AppUser{" +
				"id=" + id +
				", firstName='" + firstname + '\'' +
				", lastName='" + lastname + '\'' +
				", userName='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", role=" + role +
				'}';
	}
//endregion


}
