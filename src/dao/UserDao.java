package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.User;

public class UserDao extends Dao<User> {

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `users`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            User user = User.getFromResultSet(rs);
            users.add(user);
        }
        return users;
    }

    @Override
    public User get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `users` WHERE id = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            User user = User.getFromResultSet(rs);
            return user;
        }
        return null;
    }
    
    public User getByUsername(String username) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `users` WHERE username = '" + username + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            User user = User.getFromResultSet(rs);
            return user;
        }
        return null;
    }

    @Override
    public void save(User t) throws SQLException {
        if (t == null) {
            throw new SQLException("Empty User");
        }
        String query = "INSERT INTO `Users` (`name`, `username`, `password`) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getUsername());
        stmt.setNString(3, t.getPassword());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(User t) throws SQLException {
        if (t == null) {
            throw new SQLException("User rỗng");
        }
        String query = "UPDATE `User` SET `name` = ?, `username` = ?, `password` = ? WHERE `id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getUsername());
        stmt.setNString(3, t.getPassword());
        stmt.setInt(5, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(User t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `User` WHERE `id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();

    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `User` WHERE `id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<User> searchByKey(String key, String word) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `User` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            User user = User.getFromResultSet(rs);
            users.add(user);
        }
        return users;
    }

}
