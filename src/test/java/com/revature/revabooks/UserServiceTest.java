package com.revature.revabooks;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTest {

    private UserService sut;
    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    Set<AppUser> mockUsers = new HashSet<>();

//    @Before
//    public void setup {
//        sut = new
//    }
}
