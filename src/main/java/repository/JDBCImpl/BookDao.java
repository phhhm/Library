package repository.JDBCImpl;

import connectionManager.ConnectionManager;
import connectionManager.MySqlConnectionManager;
import model.Book;
import repository.RepoInterface;
import utility.UserNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements RepoInterface<Book> {

    public ConnectionManager connectionManager = new MySqlConnectionManager();
    private PreparedStatement statement;

    public void insert(Book book) throws SQLException {
        String query = String.format("insert into book (id, title, subject, price, penalty, status)" +
                " value ( null,'" + book.getTitle() + "','" + book.getSubject() + "',"+
                book.getPrice() + "," + book.getPenalty() + "," + (book.isStatus() ? "1" : "0") + ")");
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    public Book searchById(int id) throws UserNotFoundException, SQLException {

        String query = String.format("select * from book where id = %d", id);
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            return new Book(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getLong(4),
                    resultSet.getLong(5), resultSet.getBoolean(6));

        throw new UserNotFoundException("this book does not exist");
    }

    public List<Book> findAll() throws SQLException {
        List<Book> bookList = new ArrayList<Book>();

        String query = String.format("select * from book");
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            bookList.add(new Book(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getLong(4),
                    resultSet.getLong(5), resultSet.getBoolean(6)));

        return bookList;

    }

    public Book searchByTitle(String bookTitle) throws UserNotFoundException, SQLException {

        String query = String.format("select * from book where book.title = '%s'", bookTitle);
        statement = connectionManager.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            return new Book(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getLong(4),
                    resultSet.getLong(5), resultSet.getBoolean(6));

        throw new UserNotFoundException("this book does not exist");
    }

    public void update(Book book) throws SQLException {
        String query = String.format("update book set title = '" + book.getTitle() + "', subject = '" +
                book.getSubject() + "', price = " + book.getPrice() + ", penalty = " +
                book.getPenalty() + ", status = " +
                (book.isStatus() ? "1" : "0") + " where book.id = %d", book.getId());
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = String.format("delete from book where book.id = %d", id);
        System.out.println(query);
        statement = connectionManager.getConnection().prepareStatement(query);
        statement.executeUpdate();
    }
}
