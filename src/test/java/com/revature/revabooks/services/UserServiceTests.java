package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTests {

    private UserService sut;
    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    Set<AppUser> mockUsers = new HashSet<>();

    @Before
    public void setup() {
        sut = new UserService(mockUserRepo);
        mockUsers.add(new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN));
        mockUsers.add(new AppUser(2, "Manny", "Gerr", "admin", "manager", Role.MANAGER));
        mockUsers.add(new AppUser(3, "Alice", "Anderson", "aanderson", "secret", Role.BASIC_MEMBER));
        mockUsers.add(new AppUser(4, "Bob", "Bailey", "bbailey", "secret", Role.PREMIUM_MEMBER));
    }

    @After
    public void tearDown(){
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test
    public void authenticationWithValidCredentials() {

        // Arrange
        AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN);
        Mockito.when(mockUserRepo.findUserByCredentials(Mockito.anyString(), Mockito.anyString())).thenReturn(expectedUser);

        // Act
        AppUser actualResult = sut.authenticate("vrfhuasejbvr", "secret");

        // Assert
        Assert.assertEquals(expectedUser, actualResult);

    }

    @Test(expected = RuntimeException.class)
    public void authenticationWithInvalidCredentials(){

        // Arrange
        // nothing to do here for this test; nothing to mock

        // Act
        sut.authenticate("sfgaserg", "sdgfaer");

        // Assert
        // nothing here, because the method should have
    }

    @Test
    public void authenticationWithUnknownCredentials(){
    }

}