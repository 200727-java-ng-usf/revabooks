package com.revature.revabooks.models;

import java.util.Objects;

public class AppUser {
	//region fields/attributes
	private Integer id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Role role;
	//endregion

	//region Constructors
	public AppUser() {
		super();
	}

	public AppUser(String firstName, String lastName, String userName, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = Role.LOCKED;
	}

	public AppUser(String firstName, String lastName, String userName, String password, Role role) {
		this(firstName, lastName, userName, password);
		this.role = role;
	}

	public AppUser(Integer id, String firstName, String lastName, String userName, String password, Role role) {
		this(firstName, lastName, userName, password, role);
		this.id = id;
	}

	//copy constructor (used for convbeniently copying the values of one AppUser to create a new instance with the same values.
	public AppUser(AppUser copy){
		this(copy.id, copy.firstName, copy.lastName, copy.userName, copy.password, copy.role);
	}

	//endregion

	//region Getters And Setters
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
				Objects.equals(firstName, appUser.firstName) &&
				Objects.equals(lastName, appUser.lastName) &&
				Objects.equals(userName, appUser.userName) &&
				Objects.equals(password, appUser.password) &&
				role == appUser.role;
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
	//endregion


}
