package View;

import controller.LibraryController;
import model.Book;
import utility.Utilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BorrowView {

    Scanner scanner = new Scanner(System.in);

    public void borrow() {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String username;

        System.out.println("Borrow a book : ");

        if(Login.currentUser != null) {
            username = Login.currentUser.getUsername();
        }
        else {
            System.out.println("enter your username : ");
            username = scanner.nextLine();
        }


        Book book = Main.chooseBook();

        System.out.println("enter the date of return like this dd/mm/yyy");
        String endDateString = scanner.nextLine();

        try {
            Date date = formatter.parse(endDateString);
            Timestamp end = new Timestamp(date.getTime());
            if(!LibraryController.getInstance().borrowController.borrow(username, book, end))
                System.out.println("this book is unavailable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refund(){

        String username;

        System.out.println("Return a book :");

        if(Login.currentUser != null) {
            username = Login.currentUser.getUsername();
        }
        else {
            System.out.println("enter your username");
            username = scanner.nextLine();
        }


        System.out.println("enter book title : ");
        String bookTitle = scanner.nextLine();

        LibraryController.getInstance().borrowController.refund(username, bookTitle);
    }
}
