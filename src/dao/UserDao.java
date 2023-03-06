package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.User;

/**
 * @createAt Nov 25, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class MovieDao extends Dao<User> {

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> Movies = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `User`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            User user = User.getFromResultSet(rs);
            Movies.add(user);
        }
        return Movies;
    }

    @Override
    public User get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `User` WHERE id = " + id;
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
        String query = "INSERT INTO `User` (`price`, `dutationTime`, `title`, `country`) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getPrice());
        stmt.setInt(2, t.getDurationTime());
        stmt.setNString(3, t.getTitle());
        stmt.setNString(4, t.getCountry());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(User t) throws SQLException {
        if (t == null) {
            throw new SQLException("User rỗng");
        }
        String query = "UPDATE `User` SET `price` = ?, `durationTime` = ?, `title` = ?, `country` = ? WHERE `id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getPrice());
        stmt.setInt(2, t.getDurationTime());
        stmt.setNString(3, t.getTitle());
        stmt.setNString(4, t.getCountry());
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
