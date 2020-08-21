package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.util.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.revabooks.AppDriver.app;

public class UserRepository {

	// Extract common query clauses into a easily referenced thingamabobamagigit
	/**
	 * "SELECT * FROM revabooks.app_users au " +
	 * 			"JOIN revabooks.user_roles ur " +
	 * 			"ON au.role_id = ur.id "
	 */
	private String baseQuery = "SELECT * FROM revabooks.app_users au " +
			"JOIN revabooks.user_roles ur " +
			"ON au.role_id = ur.id ";


	public UserRepository(){
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
	}

	public Optional<AppUser> findUserByCredentials(String username, String password){

		Optional<AppUser> _user = Optional.empty();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql =
					baseQuery +
					"WHERE username = ? AND password = ? "
					;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs =  pstmt.executeQuery();
			_user = mapResultSet(rs).stream().findFirst();
//			AppUser appUser = new AppUser();
//
//			while(rs.next()){
//				appUser.setId(			rs.getInt("id"));
//				appUser.setUserName(	rs.getString("username"));
//				appUser.setPassword(	rs.getString("password"));
//				appUser.setFirstName(	rs.getString("first_name"));
//				appUser.setLastName(	rs.getString("last_name"));
////				appUser.setEmail(rs.getString("email"));
//				appUser.setRole(Role.values()[Integer.parseInt(rs.getString("role_id"))]);
//			}
//
//			_user = Optional.of(appUser);

		} catch(SQLException sqle){
			sqle.printStackTrace();
		}

		return _user;
	}

	public Optional<AppUser> findUserByUsername(String username){

		Optional<AppUser> _user = Optional.empty();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = baseQuery + "WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);

			ResultSet rs =  pstmt.executeQuery();
			_user = mapResultSet(rs).stream().findFirst();


		} catch(SQLException sqle){
			sqle.printStackTrace();
		}

		return _user;
	}

	public void save(AppUser newUser){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql =
					"INSERT INTO revabooks.app_users " +
					"(username, password, first_name, last_name, email, role_id) " +
					//(username, password, first_name, last_name, email, role_id)
					"VALUES (?, ?, ?, ?, ?, ?) "
//					"VALUES (0, ?, ?, ?, ?, ?, ?) "
					;
			// second parameter here is used to indicate column names that will have generated values
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
			pstmt.setString(1, newUser.getUserName());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getFirstName());
			pstmt.setString(4, newUser.getLastName());
			pstmt.setString(5, newUser.getEmail());
//			pstmt.setString(5, newUser.getFirstName().toLowerCase().charAt(0)
//					+ newUser.getLastName().toLowerCase()
//					+ "@revature.com");
			pstmt.setInt(6, newUser.getRole().ordinal() + 1);
//			pstmt.setInt(6, Role.getOrdinal(newUser.getRole()));

			int rowsInserted = pstmt.executeUpdate();

			if(rowsInserted != 0){

				ResultSet rs = pstmt.getGeneratedKeys();

				rs.next();
				newUser.setId(rs.getInt(1));
//					newUser.setId(rs.getInt("id")); // also works
			}

		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}

	private Set<AppUser> mapResultSet(ResultSet rs) throws SQLException {
		Set< AppUser> users = new HashSet<>();

		while(rs.next()){
			AppUser temp = new AppUser();

			temp.setId(			rs.getInt("id"));
			temp.setUserName(	rs.getString("username"));
			temp.setPassword(	rs.getString("password"));
			temp.setFirstName(	rs.getString("first_name"));
			temp.setLastName(	rs.getString("last_name"));
//				temp.setEmail(rs.getString("email"));
			// TODO figure out how to set the Role of an AppUser using a ResultSet
			temp.setRole(Role.getByName(rs.getString("name")));
			System.out.println(temp);

			users.add(temp);
		}

		return users;
	}
}
