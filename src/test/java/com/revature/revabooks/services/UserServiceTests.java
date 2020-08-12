package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTests {
    private UserService sut;
    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    Set<AppUser> mockUsers = new HashSet<>();

    @Before
    public void setUp(){
        sut = new UserService(mockUserRepo);
        mockUsers.add(new AppUser(1,"adam","admin","secret","secret", Role.ADMIN));
        mockUsers.add(new AppUser(2,"sam","admin","does","secret", Role.ADMIN));
        mockUsers.add(new AppUser(3,"max","admin","loop","secret", Role.ADMIN));
        mockUsers.add(new AppUser(4,"chad","admin","ching","secret", Role.ADMIN));

    }
    @After
    public void tearDown(){
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test
    public void authenticationWithValidCredentials(){
        //Arrange
        AppUser expectedUser = new AppUser(1,"adam","admin","secret","secret", Role.ADMIN);
        Mockito.when(mockUserRepo.findUserByCredentials(Mockito.anyString(),Mockito.anyString()))
                .thenReturn(expectedUser);
        //Act
        AppUser actualResult = sut.authenticate("adam","secret");


        //Assert
        Assert.assertEquals(expectedUser,actualResult);

    }

    @Test(expected = InvalidRequestException.class)
    public void authenticationWithInvalidCredentials(){
        //Arrange
        //noothing to do here for this test
        //nothing to mock or expect; should thorw an exception


        //Act
        sut.authenticate("asdf","asdf");

        //Assert
        //nothing here because the method should throw an exception
    }

    @Test(expected = AuthenticationException.class)
    public void authenticationWithValidUnknownCredentials(){

    }
}
