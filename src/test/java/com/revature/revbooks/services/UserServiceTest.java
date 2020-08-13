package com.revature.revbooks.services;

import com.revature.revbooks.exceptions.AuthenticationException;
import com.revature.revbooks.exceptions.InvalidRequestException;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;
import com.revature.revbooks.repos.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService sut;
    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    Set<AppUser> mockUsers = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        sut = new UserService(mockUserRepo);
        mockUsers.add(new AppUser(1,"admin","one","aaa","1234", Role.ADMIN));
        mockUsers.add(new AppUser(2,"admin","one","bbb","1234", Role.BASIC_MEMBER));
        mockUsers.add(new AppUser(3,"admin","one","ccc","1234", Role.BASIC_MEMBER));
        mockUsers.add(new AppUser(4,"admin","one","ddd","1234", Role.ADMIN));

    }

    @Test
    public void authenticate() {

        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test
    public void authenticationWithValidCredentials() throws InvalidRequestException, AuthenticationException {

        // Arrange
        AppUser expectedUser = new AppUser(1,"admin","one","aaa","1234", Role.ADMIN);
        Mockito.when(mockUserRepo.findUserCredentials(Mockito.anyString(),Mockito.anyString()))
                .thenReturn(expectedUser);

        // Act
        AppUser actualResult = sut.authenticate("aaa","1234");

        //Assert
        Assert.assertEquals(expectedUser,actualResult);

    }

    @Test(expected = RuntimeException.class)
    public void authenticationWithInvalidCredentials() throws InvalidRequestException, AuthenticationException {
        // Arrange

        // Act
       // sut.authenticate("aaa","1234");

        //Assert

    }

    @Test
    public void authenticationWithKnowCredentials() {
    }

    @Test
    public void update() {
    }

    @Test
    public void isUserValid() {
    }
}