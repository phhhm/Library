package repository;

import repository.JDBCImpl.BookDao;
import repository.JDBCImpl.BorrowDao;
import repository.JDBCImpl.UserDao;

public class LibraryRepository {

    public static final LibraryRepository libraryRepository = new LibraryRepository();

    public UserDao userDao;
    public BookDao bookDao;
    public BorrowDao borrowDao;

    LibraryRepository(){
        userDao = new UserDao();
        bookDao = new BookDao();
        borrowDao = new BorrowDao();
    }

    public static LibraryRepository getInstance(){
        return libraryRepository;
    }
}
