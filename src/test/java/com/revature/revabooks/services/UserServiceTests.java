package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTests {

    private UserService sut;
    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    Set<AppUser> mockUsers = new HashSet<>();

    @Before
    public void setup() {
//        sut = new UserService();

    }
}
