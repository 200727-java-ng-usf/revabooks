package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository {

    // extract common query clauses into a easily referenced member for reusability.
    private String baseQuery = "SELECT * FROM revabooks.app_users au " +
                               "JOIN revabooks.user_roles ur " +
                               "ON au.role_id = ur.id ";

    public UserRepository() {
        super();
    }

    public Optional<AppUser> findUserById(int id) {

        Optional<AppUser> opUser = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = baseQuery + "WHERE au.id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            Set<AppUser> result = mapResultSet(pstmt.executeQuery());
            if (!result.isEmpty()) {
                opUser = result.stream().findFirst();
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return opUser;
    }

    public Set<AppUser> findAllUsers() {

        Set<AppUser> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = baseQuery;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;

    }

    public Optional<AppUser> findUserByCredentials(String username, String password) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = baseQuery + "WHERE username = ? AND password = ?";

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

            String sql = "INSERT INTO revabooks.app_users (username, password, first_name, last_name, email, role_id) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            // second parameter here is used to indicate column names that will have generated values
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getRole().ordinal() + 1);

           // pstmt.executeUpdate();

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                newUser.setId(rs.getInt(1));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    private Set<AppUser> mapResultSet(ResultSet rs) throws SQLException {

        Set<AppUser> users = new HashSet<>();

        while (rs.next()) {
            AppUser temp = new AppUser();
            temp.setId(rs.getInt("id"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setEmail(rs.getString("email"));
            temp.setRole(Role.getByName(rs.getString("name")));
            users.add(temp);
        }

        return users;

    }

}
