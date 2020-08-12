package com.revature.revabooks;


import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepo;
import com.revature.revabooks.services.UserService;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserServiceTest {
    private UserService sut;
    private UserRepo mockUserRepo = Mockito.mock(UserRepo.class);
    Set<AppUser> mockUsers = new HashSet<>();
}
