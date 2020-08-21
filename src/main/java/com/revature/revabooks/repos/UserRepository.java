package com.revature.revabooks.repos;


import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {


    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    public Optional<AppUser> findUserByCredentials(String username, String password) {

        Optional<AppUser> _user = Optional.empty();


        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM revabooks.app_users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            AppUser appUser = new AppUser();

            while(rs.next()) {
                appUser.setId(rs.getInt("id"));
                appUser.setUsername(rs.getString("username"));
                appUser.setPassword(rs.getString("password"));
                appUser.setFirstName(rs.getString("first_name"));
                appUser.setLastName(rs.getString("last_name"));
            }

            _user = Optional.of(appUser);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


        return _user;
    }

    public Optional<AppUser> findUserByUsername(String username) {
        return Optional.of(null);
    }

    public Optional<AppUser> save(AppUser newUser) {
        return Optional.of(null);
    }

}
