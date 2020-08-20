package com.revature.revabooks.services;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class UserServiceTest {

	private UserService sut;
	private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
	Set<AppUser> mockUsers = new HashSet<>();

	@Before
	public void setUp() {
		sut = new UserService(mockUserRepo);
		mockUsers.add(new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN));
		mockUsers.add(new AppUser(2, "Manny", "Gerr", "manager", "manage", Role.ADMIN));
		mockUsers.add(new AppUser(3, "Alice", "Anderson", "aanderson", "password", Role.BASIC_MEMBER));
		mockUsers.add(new AppUser(4, "Bob", "Bailey", "bbailey", "dev", Role.PREMIUM_MEMBER));

	}

	@After
	public void tearDown() throws Exception {
		sut = null;
		mockUsers.removeAll(mockUsers);
	}

//	@Test
//	public void AuthenticationWithValidCredentials(){
//
//		// Arrange
//		AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN);
//		Mockito.when(mockUserRepo.findUserByCredentials("admin", "secret"))
//				.thenReturn(Optional.of(expectedUser));
//
//		// Act
//		AppUser actualResult = sut.authenticate("admin", "secret");
//
//		// Assert
////		assertNotNull(actualResult);
//		assertEquals(expectedUser, actualResult);
//
//	}
//
//	@Test(expected = AuthenticationException.class)
//	public void AuthenticationWithInValidCredentials(){
//
//		// Arrange
////		AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN);
////		Mockito.when(mockUserRepo.findUserByCredentials("admin", "secret"))
////				.thenReturn(expectedUser);
//
//		// Act
//		AppUser actualResult = sut.authenticate("charmin", "secret");
//
//		// Assert
////		assertNotNull(actualResult);
////		assertEquals(expectedUser, actualResult);
//	}
//
//	@Test(expected = InvalidRequestException.class)
//	public void AuthenticationWithUnknownCredentials(){
//
//		// Arrange
////		AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN);
////		Mockito.when(mockUserRepo.findUserByCredentials("admin", "secret"))
////				.thenReturn(expectedUser);
//
//		// Act
//		AppUser actualResult = sut.authenticate("", "secret");
//
//		// Assert
////		assertNotNull(actualResult);
////		assertEquals(expectedUser, actualResult);
//	}


}