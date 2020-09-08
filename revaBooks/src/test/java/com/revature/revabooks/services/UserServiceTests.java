//package com.revature.revabooks.services;
//
//import com.revature.revabooks.exceptions.AuthenticationException;
//import com.revature.revabooks.exceptions.InvalidRequestException;
//import com.revature.revabooks.models.AppUser;
//import com.revature.revabooks.models.Role;
//import com.revature.revabooks.repos.UserRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//public class UserServiceTests {
//
//    private UserService sut;
//    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
//    Set<AppUser> mockUsers = new HashSet<>();
//
//    @Before
//    public void setup() {
//        sut = new UserService(mockUserRepo);
//        mockUsers.add(new AppUser(1, "Adam", "Inn", "admin", "secret", "admin@", Role.ADMIN ));
//        mockUsers.add(new AppUser(2, "Manny", "Gerr", "mann@", "manager", "manage@", Role.MANAGER ));
//        mockUsers.add(new AppUser(3, "Alice", "Anderson", "aandserson", "password", "nerd@", Role.BASIC_MEMBER ));
//        mockUsers.add(new AppUser(4, "Bob", "Bailey", "bbailey", "dev", "dev@", Role.PREMIUM_MEMBER ));
//    }
//
//    @After
//    public void teardown() {
//        sut = null;
//        mockUsers.removeAll(mockUsers);
//    }
//
////    @Test
////    public void authenticationWithValidCredentials() {
////        // Arrange
////        AppUser expectedUser = new AppUser(1, "Adam", "Inn", "admin", "secret", Role.ADMIN);
////        Mockito.when(mockUserRepo.findUserByCredentials("admin", "secret"))
////                .thenReturn(expectedUser);
////
////        //Act
////        AppUser actualResult = sut.authenticate("admin", "secret");
////
////        //Assert
////        Assert.assertEquals(expectedUser, actualResult);
////    }
//
//    @Test(expected = InvalidRequestException.class)
//    public void authenticationWithInvalidCredentials() {
//        //no arrange
//
//        // Act
//        sut.authenticate("","");
//
//        //no assert, should raise an exceptionm
//    }
//
//    @Test(expected = AuthenticationException.class)
//    public void authenticationWithUnknownCredentials() {
//
//        sut.authenticate("garbage", "user");
//
//    }
//
//
//
//}
