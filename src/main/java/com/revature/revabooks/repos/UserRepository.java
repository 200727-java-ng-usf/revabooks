package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.utilities.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository {

    private String baseQuery = "SELECT * FROM revabooks.app_users au " +
            "JOIN revabooks.user_roles ur " +
            "ON au.role_id = ur.id ";

    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    public Optional<AppUser> findUserByCredentials(String username, String password) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql =  baseQuery +
                            "WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            _user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return _user;
    }

    public Optional<AppUser> findUserByUsername(String username) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = baseQuery + "WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return _user;

        }


    public void save(AppUser newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO revabooks.app_users " +
                    "(username, password, first_name, last_name, email, role_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?,)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});

            pstmt.setString(1, newUser.getUserName());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getRole().ordinal() + 1);

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    newUser.setId(rs.getInt(1));
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

        private Set<AppUser> mapResultSet(ResultSet rs) throws SQLException {
            Set<AppUser> users = new HashSet<>();

            while (rs.next()) {
                AppUser temp = new AppUser();
                temp.setId(rs.getInt("id"));
                temp.setUserName(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setRole(Role.getByName(rs.getString("name")));

                users.add(temp);
            }
            return users;
        }
    }
