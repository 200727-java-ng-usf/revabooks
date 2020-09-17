package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.util.ConnectionFactory;
import com.revature.revabooks.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
	Recommended methods to implement:

		- Set<AppUser> findAllUsers()
		- Optional<AppUser> findUserById(int id)
		- Set<AppUser> find UsersByRole(String rolename)
		- boolean/void/AppUser update(AppUser updatedUser)
		- boolean/void deleteUserById(int id)
		- Optional<AppUser> findUserByEmail(String email)
 */
public class UserRepository {

	private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	// Extract common query clauses into a easily referenced thingamabobamagigit
	/**
	 * "SELECT * FROM revabooks.app_users au " +
	 * 			"JOIN revabooks.user_roles ur " +
	 * 			"ON au.role_id = ur.id "
	 */
	private String baseQuery = "SELECT * FROM revabooks.app_users au " +
			"JOIN revabooks.user_roles ur " +
			"ON au.role_id = ur.id ";

	public Optional<AppUser> findUserById(int id){
		Optional<AppUser> _user = Optional.empty();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = baseQuery + "WHERE au.id = ? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
//			ResultSet rs = pstmt.executeQuery(sql);
			Set<AppUser> result = mapResultSet(pstmt.executeQuery());
			if(!result.isEmpty()){
				_user = result.stream().findFirst();
			}
//			_user = mapResultSet(rs).stream().findFirst();


		} catch(SQLException e) {
			e.printStackTrace();
		}

		return _user;
	}

	public Set<AppUser>findAllUsers(){
		Set<AppUser> users = new HashSet<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = baseQuery;

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			users = mapResultSet(rs);


		} catch(Exception e) {
		    e.printStackTrace();
		}

		return users;
	}

	public UserRepository(){
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
	}

	public Optional<AppUser> findUserByCredentials(String username, String password){

		Optional<AppUser> _user = Optional.empty();
		Session session = sessionFactory.getCurrentSession();
		try{

			Transaction tx = session.beginTransaction();
			AppUser retrievedUser = session.createQuery(
					"from AppUser au where au.username = :un and password = :pw"
					, AppUser.class)
					.setParameter("un", username)
					.setParameter("pw", password)
					.getSingleResult();
			_user = Optional.of(retrievedUser);
			tx.commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
		    e.printStackTrace();
		}
		session.close(); // not really required, since the Session object is scoped to this metho
		// and once this method returns, the Session objcet will be garbage collected and subsequently closed.
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
//
//			String sql =
//					baseQuery +
//					"WHERE username = ? AND password = ? "
//					;
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, username);
//			pstmt.setString(2, password);
//
//			ResultSet rs =  pstmt.executeQuery();
//			_user = mapResultSet(rs).stream().findFirst();
////			AppUser appUser = new AppUser();
////
////			while(rs.next()){
////				appUser.setId(			rs.getInt("id"));
////				appUser.setUserName(	rs.getString("username"));
////				appUser.setPassword(	rs.getString("password"));
////				appUser.setFirstName(	rs.getString("first_name"));
////				appUser.setLastName(	rs.getString("last_name"));
//////				appUser.setEmail(rs.getString("email"));
////				appUser.setRole(Role.values()[Integer.parseInt(rs.getString("role_id"))]);
////			}
////
////			_user = Optional.of(appUser);
//
//		} catch(SQLException sqle){
//			sqle.printStackTrace();
//		}

		return _user;
	}

	public Optional<AppUser> findUserByUsername(String username){

		Optional<AppUser> _user = Optional.empty();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			// you can control whether or not JDBC automatically commits DML statements
//			conn.setAutoCommit(false);

			String sql = baseQuery + "WHERE username = ?";
//			Statement stmt = conn.createStatement();
//			stmt.executeQuery(sql);

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);

			ResultSet rs =  pstmt.executeQuery();
			_user = mapResultSet(rs).stream().findFirst();

			//
//			conn.commit();

		} catch(SQLException sqle){
			sqle.printStackTrace();
		}

		return _user;
	}

	public Optional<AppUser> findUserByEmail(String email) {

		Optional<AppUser> _user = Optional.empty();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = baseQuery + "WHERE email = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			_user = mapResultSet(rs).stream().findFirst();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return _user;

	}

	public void save(AppUser newUser){
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(newUser);
			tx.commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
		    e.printStackTrace();
		}
		session.close();
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
//
//			String sql =
//					"INSERT INTO revabooks.app_users " +
//					"(username, password, first_name, last_name, email, role_id) " +
//					//(username, password, first_name, last_name, email, role_id)
//					"VALUES (?, ?, ?, ?, ?, ?) "
////					"VALUES (0, ?, ?, ?, ?, ?, ?) "
//					;
//			// second parameter here is used to indicate column names that will have generated values
//			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
//			pstmt.setString(1, newUser.getUsername());
//			pstmt.setString(2, newUser.getPassword());
//			pstmt.setString(3, newUser.getFirstName());
//			pstmt.setString(4, newUser.getLastName());
//			pstmt.setString(5, newUser.getEmail());
////			pstmt.setString(5, newUser.getFirstName().toLowerCase().charAt(0)
////					+ newUser.getLastName().toLowerCase()
////					+ "@revature.com");
//			pstmt.setInt(6, newUser.getRole().ordinal() + 1);
////			pstmt.setInt(6, Role.getOrdinal(newUser.getRole()));
//
//			int rowsInserted = pstmt.executeUpdate();
//
//			if(rowsInserted != 0){
//
//				ResultSet rs = pstmt.getGeneratedKeys();
//
//				rs.next();
//				newUser.setId(rs.getInt(1));
////					newUser.setId(rs.getInt("id")); // also works
//			}
//
//		} catch(SQLException sqle){
//			sqle.printStackTrace();
//		}
	}

	private Set<AppUser> mapResultSet(ResultSet rs) throws SQLException {
		Set< AppUser> users = new HashSet<>();

		while(rs.next()){
			AppUser temp = new AppUser();

			temp.setId(			rs.getInt("id"));
			temp.setUsername(	rs.getString("username"));
			temp.setPassword(	rs.getString("password"));
			temp.setFirstName(	rs.getString("first_name"));
			temp.setLastName(	rs.getString("last_name"));
//				temp.setEmail(rs.getString("email"));
			// TODO figure out how to set the Role of an AppUser using a ResultSet
			temp.setRole(Role.getByName(rs.getString("name")));
//			System.out.println(temp);

			users.add(temp);
		}

		return users;
	}
}
