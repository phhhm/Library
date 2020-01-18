package View;


import controller.LibraryController;
import model.Book;
import utility.Utilities;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Login login = new Login();
    static Register register = new Register();
    static BorrowView borrowView = new BorrowView();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        register.register();
//        login.login();
//        borrow.borrow();
//        borrow.refund();

        firstMenu();
    }

    public static void firstMenu(){
        int number;

        System.out.println("welcome");
        System.out.println("1 - register");
        System.out.println("2 - login");
        System.out.println("3 - add a book");
        System.out.println("enter a number : ");

        number = scanner.nextInt();

        switch (number){
            case 1:
                register.register();
                firstMenu();
                break;
            case 2:
                login.login();
                secondMenu();
                break;
            case 3:
                addBook();
                firstMenu();
                break;
            default:
                System.out.println("invalid number");
        }
    }

    private static void secondMenu() {
        int number;

        System.out.println("hello " + Login.currentUser.getName());

        System.out.println("1 - borrow");
        System.out.println("2 - return");
        System.out.println("3 - back to first menu");
        System.out.println("enter a number : ");

        number = scanner.nextInt();

        switch (number){
            case 1:
                borrowView.borrow();
                secondMenu();
                break;
            case 2:
                borrowView.refund();
                secondMenu();
                break;
            case 3:
                firstMenu();
                break;
            default:
                System.out.println("invalid number");
        }
    }

    public static void addBook(){

        System.out.println("Add Book : ");

        System.out.println("enter book title :");
        String title = scanner.nextLine();

        System.out.println("enter book subject :");
        String subject = scanner.nextLine();

        System.out.println("enter book price :");
        Long price = scanner.nextLong();

        System.out.println("enter book penalty :");
        Long penalty = scanner.nextLong();

        Book book = new Book(title, subject, price, penalty);

        LibraryController.getInstance().bookController.insert(book);
        System.out.println();
        showBooks();
    }

    public static List<Book> showBooks(){
        List<Book> bookList = LibraryController.getInstance().bookController.findAll();

        for (int i = 1; i <= bookList.size(); i++) {
            System.out.println( i + " - title : " + bookList.get(i-1).getTitle() + " , subject : " +
                    bookList.get(i-1).getSubject());
        }
        System.out.println();
        return bookList;
    }

    public static Book chooseBook(){
        Book book;
        int number;

        List<Book> bookList = showBooks();

        System.out.println("enter book number :");
        number = scanner.nextInt();

        System.out.println();
        return bookList.get(number - 1);
    }
}
