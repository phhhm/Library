package service;

import model.User;
import model.Book;
import model.Borrow;
import repository.LibraryRepository;
import utility.UserNotFoundException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class BorrowService {

    public boolean borrow(String username, String bookTitle, Timestamp end) {
        try {
            Book book = LibraryRepository.getInstance().bookDao.searchByTitle(bookTitle);
            User user = LibraryRepository.getInstance().userDao.searchByUsername(username);
            if(book == null || !book.isStatus()) {
                System.out.println("book is unavailable");
                return false;
            }
            if(!user.isStatus()){
                System.out.println("this user is deactive");
                return false;
            }

            Borrow borrow = new Borrow(user.getId(), book.getId(), end);
            LibraryRepository.getInstance().borrowDao.insert(borrow);
            book.setStatus(false);
            LibraryRepository.getInstance().bookDao.update(book);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Borrow> findAll(){
        try {
            return LibraryRepository.getInstance().borrowDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Borrow borrow){
        try {
            LibraryRepository.getInstance().borrowDao.update(borrow);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public void refund(String username, String bookTitle) {
        try {
            User user = LibraryRepository.getInstance().userDao.searchByUsername(username);
            Book book = LibraryRepository.getInstance().bookDao.searchByTitle(bookTitle);

            Borrow borrow = LibraryRepository.getInstance().borrowDao.searchByUserAndBook(user.getId(), book.getId());

            if (new Timestamp(System.currentTimeMillis()).after(borrow.end)) {
                user.setDelayCount(user.getDelayCount() + 1);
                if(user.getDelayCount() >= 2)
                    user.setStatus(false);
                LibraryRepository.getInstance().userDao.update(user);
            }

            book.setStatus(true);
            LibraryRepository.getInstance().bookDao.update(book);

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public void deleteById(int id){
        try {
            LibraryRepository.getInstance().borrowDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
