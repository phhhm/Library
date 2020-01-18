package controller;

import model.Borrow;
import service.BorrowService;

import java.sql.Timestamp;
import java.util.List;

public class BorrowController {

    BorrowService borrowService = new BorrowService();

    public boolean borrow(String username, String bookTitle, Timestamp end) {
        return borrowService.borrow(username, bookTitle, end);
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
