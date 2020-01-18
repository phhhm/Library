package controller;

import model.Book;
import model.Borrow;
import service.BorrowService;

import java.sql.Timestamp;
import java.util.List;

public class BorrowController {

    BorrowService borrowService = new BorrowService();

    public boolean borrow(String username, Book book, Timestamp end) {
        return borrowService.borrow(username, book, end);
    }

    public List<Borrow> findAll(){
        return borrowService.findAll();
    }

    public void refund(String username, String bookTitle) {
        borrowService.refund(username, bookTitle);
    }

    public void update(Borrow borrow){
        borrowService.update(borrow);
    }

    public void deleteById(int id){
        borrowService.deleteById(id);
    }
}
