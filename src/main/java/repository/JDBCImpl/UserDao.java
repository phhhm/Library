package repository.JDBCImpl;

import connectionManager.ConnectionManager;
import connectionManager.MySqlConnectionManager;
import model.User;
import repository.RepoInterface;
import utility.UserNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements RepoInterface<User> {

    public ConnectionManager connectionManager = new MySqlConnectionManager();
    private PreparedStatement statement;

    public void insert(User user) throws SQLException {
        String query = String.format("insert into user (id, name, username, password, national_code, creation," +
                " delay_count, status)" +" value ( null,'" + user.getName() + "','" + user.getUsername() + "','"+
                user.getPassword() + "','" + user.getNationalCode() + "','" + user.getCreation() + "','" +
                user.getDelayCount() + "','" + (user.isStatus() ? "1" : "0") + "')");
        System.out.println(query);

        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    public User searchById(int id) throws UserNotFoundException, SQLException {

        String query = String.format("select * from user where id = %d", id);
        System.out.println(connectionManager.getConnection().getMetaData());
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getTimestamp(6),
                    resultSet.getInt(7), resultSet.getBoolean(8));

        throw new UserNotFoundException("this user does not exist");
    }

    public List<User> findAll() throws SQLException {
        List<User> userList = new ArrayList<User>();

        String query = String.format("select * from user");
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            userList.add(new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getTimestamp(6),
                    resultSet.getInt(7), resultSet.getBoolean(8)));

        return userList;
    }

    public User searchByUsername(String username) throws UserNotFoundException, SQLException {

        String query = String.format("select * from user where username = '%s'", username);
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getTimestamp(6),
                    resultSet.getInt(7), resultSet.getBoolean(8));

        throw new UserNotFoundException("this user does not exist");
    }

    public void update(User user) throws SQLException {
        String query = String.format("update user set name = '" + user.getName() + "', username = '" +
                user.getUsername() + "', password = '" + user.getPassword() + "', national_code = '" +
                user.getNationalCode() + "', delay_count = " + user.getDelayCount() + ", status = " +
                (user.isStatus() ? "1" : "0") + " where user.id = %d", user.getId());
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = String.format("delete from user where user.id = %d", id);
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }
}
