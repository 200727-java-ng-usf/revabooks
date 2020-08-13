package com.revature.revbooks.db;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;
import com.revature.revbooks.repos.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDBTest {

    AppUser testUser,receiver;
    UserDB userDB;

    @Before
    public void setUp() throws Exception {

        testUser = new AppUser("eee","fff","ggg","1234", Role.BASIC_MEMBER);
        userDB = new UserDB();
        receiver = new AppUser();

    }

    @After
    public void tearDown() throws Exception {
        testUser = null;
        userDB = null;

    }

    @Test
    public void addUser() {
        receiver = userDB.addUser(testUser);
        System.out.println(receiver.toString());
        receiver.setId(1);
        System.out.println(receiver.toString());



    }
}