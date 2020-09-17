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
        - Set<AppUser> findUsersByRole(String rolename)
        - boolean/void updateUser(AppUser updatedUser)
        - boolean/void deleteUserById(int id)
        - Optional<AppUser> findUserByEmail(String email)
 */
public class UserRepository {

    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    // extract common query clauses into a easily referenced member for reusability.
    private String baseQuery = "SELECT * FROM app_users au " +
                               "JOIN user_roles ur " +
                               "ON au.role_id = ur.id ";

    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    public Optional<AppUser> findUserById(int id) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = baseQuery + "WHERE au.id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            Set<AppUser> result = mapResultSet(pstmt.executeQuery());
            if (!result.isEmpty()) {
                _user = result.stream().findFirst();
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return _user;

    }

    public Set<AppUser> findAllUsers() {

        Set<AppUser> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM app_users au " +
                         "JOIN user_roles ur " +
                         "ON au.role_id = ur.id";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;

    }

    public Optional<AppUser> findUserByCredentials(String username, String password) {

        Session session = sessionFactory.getCurrentSession();
        Optional<AppUser> _user = Optional.empty();

        try {

//            session.beginTransaction();
//            Query query = session.createQuery("from AppUser au where au.username = :un and password = :pw", AppUser.class);
//            query.setParameter("un", username);
//            query.setParameter("pw", password);
//            AppUser retrievedUser = (AppUser) query.getSingleResult();
//            _user = Optional.of(retrievedUser);

            // does the same thing as the comment out code above (just a bit more concise)
            session.beginTransaction();
            AppUser retrievedUser = session.createQuery("from AppUser au where au.username = :un and password = :pw", AppUser.class)
                                           .setParameter("un", username)
                                           .setParameter("pw", password)
                                           .getSingleResult();

            _user = Optional.of(retrievedUser);

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return _user;
    }

    public Optional<AppUser> findUserByUsername(String username) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            // you can control whether or not JDBC automatically commits DML statements
//            conn.setAutoCommit(false);

            String sql = baseQuery + "WHERE username = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();

            // if you want to manually control the transaction
//            conn.commit();
//            conn.rollback();
//            conn.setSavepoint();

        } catch (SQLException sqle) {
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

    public void save(AppUser newUser) {

        Session session = sessionFactory.getCurrentSession();

        try {

            Transaction tx = session.beginTransaction();
            session.save(newUser);
            tx.commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        session.close(); // not really required, since the Session object is scoped to this method
        // and once this method returns, the Session object will be garbage collection and subsequently closed

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
            temp.setRole(Role.getByName(rs.getString("name")));
            temp.setEmail(rs.getString("email"));
            users.add(temp);
        }

        return users;

    }

}
