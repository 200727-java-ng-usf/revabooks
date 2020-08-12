package com.revature.revabooks;


import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepo;
import com.revature.revabooks.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTest {
    private UserService sut;
    private UserRepo mockUserRepo = Mockito.mock(UserRepo.class);
    Set<AppUser> mockUsers = new HashSet<>();

    @Before
    public void setup(){
        sut = new UserService(mockUserRepo);
        mockUsers.add(new AppUser(1,"Adam","Inn","admin","p4ssw0rd", Role.ADMIN));

    }

    @After
    public  void tearDown(){
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test
    public void authenticationWithValidCredentials(){
        //Arrange
        AppUser expectedUser = new AppUser(1,"Adam","Inn","admin","p4ssw0rd", Role.ADMIN);
//        Mockito.when(mockUserRepo).findUserCredentials(Mockito.anyString()).then;
        //Act

        //Assert
    }

    @Test(expected = RuntimeException.class)
    public void authenticationWithInvalidCredentials(){
        sut.authentic("","");
        //Arrange (null)
        //
    }
}
