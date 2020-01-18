package repository;

import java.sql.SQLException;
import java.util.List;

public interface RepoInterface<E> {

    void insert(E e) throws SQLException;
    E searchById(int id) throws Exception;
    List<E> findAll() throws SQLException;
    void update(E e) throws SQLException;
    void delete(int id) throws SQLException;
}
