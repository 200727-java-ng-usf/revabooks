package com.revature.revabooks;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTest {

    private UserService sut;
    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    Set<AppUser> mockUsers = new HashSet<>();

    @Before
    public void setup() {
        sut = new UserService(mockUserRepo);
        mockUsers.add(new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN));
        mockUsers.add(new AppUser(1, "Manny", "Ger", "manager", "m4n4ge", Role.MANAGER));
        mockUsers.add(new AppUser(1, "Allison", "Wonderland", "rabbit", "qn0fH4rts", Role.PREMIUM_MEMBER));
        mockUsers.add(new AppUser(1, "Bob", "Barker", "bbk", "priceRight", Role.BASIC_MEMBER));
    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

//    @Test
//    public void authenticateWithValidCredentials() {
//        AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
//        Mockito.when(mockUserRepo.findUserByCredentials(Mockito.anyString(), Mockito.anyString()))
//                .thenReturn(expectedUser);
//
//        AppUser actualResult = sut.authenticate("admin", "password");
//
//        Assert.assertEquals(expectedUser, actualResult);
//
//    }

    @Test(expected = RuntimeException.class)
    public void authenticateWithInvalidCredentials() {

        sut.authenticate("", "");

    }

//    @Test
//    public void authenticateWithUnknownCredentials() {
//        AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
//        Mockito.when(mockUserRepo.findUserByCredentials(Mockito.anyString(), Mockito.anyString()))
//                .thenReturn(expectedUser);
//
//        AppUser actualResult = sut.authenticate("admin", "password");
//
//        Assert.assertEquals(expectedUser, actualResult);
//    }
}
