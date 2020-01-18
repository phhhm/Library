package repository.JDBCImpl;

import connectionManager.ConnectionManager;
import connectionManager.MySqlConnectionManager;
import model.Borrow;
import repository.RepoInterface;
import utility.UserNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao implements RepoInterface<Borrow> {

    public ConnectionManager connectionManager = new MySqlConnectionManager();
    private PreparedStatement statement;

    public void insert(Borrow borrow) throws SQLException {
        String query = String.format("insert into borrow (id, user_id, book_id, start, end)" +
                " value ( null,'" + borrow.getUser_id() + "','" + borrow.getBook_id() + "','"+
                borrow.getStart() + "','" + borrow.getEnd() + "')");
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    public Borrow searchById(int id) throws UserNotFoundException, SQLException {
        String query = String.format("select * from borrow where id = %d", id);
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            return new Borrow(resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getInt(3),resultSet.getTimestamp(4),
                    resultSet.getTimestamp(5));

        throw new UserNotFoundException("this borrow does not exist");
    }

    public Borrow searchByUserAndBook(Integer userId, Integer bookId) throws UserNotFoundException, SQLException {
        String query = String.format("select * from borrow where user_id = %d and book_id = %d", userId, bookId);
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            return new Borrow(resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getInt(3),resultSet.getTimestamp(4),
                    resultSet.getTimestamp(5));

        throw new UserNotFoundException("this borrow does not exist");
    }

    public List<Borrow> findAll() throws SQLException {
        List<Borrow> borrowList = new ArrayList<Borrow>();

        String query = String.format("select * from borrow");
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            borrowList.add(new Borrow(resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getInt(3),resultSet.getTimestamp(4),
                    resultSet.getTimestamp(5)));

        return borrowList;
    }

    public void update(Borrow borrow) throws SQLException {
        String query = String.format("update borrow set user_id = " + borrow.getUser_id() + ", book_id = "
                + borrow.getBook_id() + ", start = '" + borrow.getStart() + "', end = '" + borrow.getEnd() +
                "' where borrow.id = %d", borrow.getId());
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = String.format("delete from borrow where borrow.id = %d", id);
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }
}
