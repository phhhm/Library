package View;

import controller.BorrowController;
import utility.Utilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BorrowView {

    public static BorrowController borrowController = new BorrowController();

    public void borrowView() {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String username;
        if(Login.currentUser != null)
             username = Login.currentUser.getUsername();
        else {
            System.out.println("enter your username");
            username = Utilities.getInstance().getStringFromUser();
        }

        System.out.println("enter title of book");
        String title = Utilities.getInstance().getStringFromUser();

        System.out.println("enter the date of return like this dd/mm/yyy");
        String endDateString = Utilities.getInstance().getStringFromUser();

        try {
            Date date = formatter.parse(endDateString);
            Timestamp end = new Timestamp(date.getTime());
            if(!borrowController.borrow(username, title, end))
                System.out.println("this book is unavailable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refund(){

        String username;
        if(Login.currentUser != null)
            username = Login.currentUser.getUsername();
        else {
            System.out.println("enter your username");
            username = Utilities.getInstance().getStringFromUser();
        }

        System.out.println("enter book title : ");
        String bookTitle = Utilities.getInstance().getStringFromUser();

        borrowController.refund(username, bookTitle);
    }
}
