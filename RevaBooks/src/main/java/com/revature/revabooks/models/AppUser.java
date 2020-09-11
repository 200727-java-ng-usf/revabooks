package com.revature.revabooks.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="app_user")
public class AppUser {
	//region fields/attributes
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String email;

	// Role is an Enum and cannot be mapped using @JoinColumn
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "role_id")
	@Enumerated(EnumType.STRING)
	private Role role;
	//endregion

	//region Constructors
	// no-args contructors are required for jackson to map properly
	public AppUser() {
		super();
	}

	public AppUser(String firstName, String lastName, String userName, String password, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.role = Role.LOCKED;
	}

	public AppUser(String firstName, String lastName, String userName, String password, String email, Role role) {
		this(firstName, lastName, userName, password, email);
		this.role = role;
	}

	public AppUser(Integer id, String firstName, String lastName, String userName, String password, String email, Role role) {
		this(firstName, lastName, userName, password, email, role);
		this.id = id;
	}

	//copy constructor (used for convbeniently copying the values of one AppUser to create a new instance with the same values.
	public AppUser(AppUser copy){
		this(copy.id, copy.firstName, copy.lastName, copy.username, copy.password, copy.email, copy.role);
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
				Objects.equals(firstName, appUser.firstName) &&
				Objects.equals(lastName, appUser.lastName) &&
				Objects.equals(username, appUser.username) &&
				Objects.equals(password, appUser.password) &&
				Objects.equals(email, appUser.email) &&
				role == appUser.role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, username, password, email, role);
	}

	@Override
	public String toString() {
		return "AppUser{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", userName='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", role=" + role +
				'}';
	}
//endregion


}
