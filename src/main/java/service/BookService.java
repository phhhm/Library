package service;

import model.Book;
import repository.LibraryRepository;
import utility.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    public void insert(Book book){
        try {
            LibraryRepository.getInstance().bookDao.insert(book);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public Book searchById(int id) {
        try {
            return LibraryRepository.getInstance().bookDao.searchById(id);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return new Book();
    }

    public Book searchByTitle(String bookTitle) {
        try {
            return LibraryRepository.getInstance().bookDao.searchByTitle(bookTitle);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return new Book();
    }

    public List<Book> findAll(){
        try {
            return LibraryRepository.getInstance().bookDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Book book){
        try {
            LibraryRepository.getInstance().bookDao.update(book);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public void deleteById(int id){
        try {
            LibraryRepository.getInstance().bookDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByTitle(String title){
        try {
            Book book = LibraryRepository.getInstance().bookDao.searchByTitle(title);
            deleteById(book.getId());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
