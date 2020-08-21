package com.revature.revabooks.repos;


import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepo {

    //TODO replace mock implementation with in-memory persistence

    public Optional<AppUser> findUserByCredentials(String username, String password){
        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM revabooks.app_users au "+
                        "JOIN revabooks.user_roles ur "+
                        "ON au.role_id = ur.id"+
                        " WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            AppUser appUser = new AppUser();

            while (rs.next()){
                appUser.setId(rs.getInt("id"));
                appUser.setUsername(rs.getString("username"));
                appUser.setPassword(rs.getString("password"));
                appUser.setFirstName(rs.getString("first_name"));
                appUser.setLastName(rs.getString("last_name"));
            }
             _user = Optional.of(appUser);

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }


        return _user;
    }

    public Optional<AppUser>save(AppUser newUser){

        Optional<AppUser> _user = Optional.empty();


        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "INSERT INTO revabooks.app_users(username, password, first_name, last_name, role_id) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});
            pstmt.setString(1,newUser.getUsername());
            pstmt.setString(2,newUser.getPassword());
            pstmt.setString(3,newUser.getFirstName());
            pstmt.setString(4,newUser.getLastName());
            pstmt.setString(5,newUser.getEmail());
            pstmt.setInt(6, newUser.getRole().ordinal() +1 );

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();

                rs.next();
                newUser.setId(rs.getInt(1));

            }

        } catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return _user;

    }

    public Optional<AppUser> findUserByUsername(String username) {

            Optional<AppUser> _user = Optional.empty();
            try( Connection conn = ConnectionFactory.getInstance().getConnection()){

                String sql = "SELECT * FROM revabooks.app_users WHERE username = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,username);


                ResultSet rs = pstmt.executeQuery();
                _user = mapResultSet(rs).stream().findFirst();

            }catch(SQLException sqle){
                sqle.printStackTrace();
            }

            return _user;
    }

    public UserRepo() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    private Set<AppUser> mapResultSet(ResultSet rs) throws SQLException {

        Set<AppUser> user = new HashSet<>();

        while (rs.next()){
            AppUser temp = new AppUser();
            temp.setId(rs.getInt("id"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setRole(Role.getByName(rs.getString("name")));
            user.add(temp);

        }

        return  user;

    }

}
