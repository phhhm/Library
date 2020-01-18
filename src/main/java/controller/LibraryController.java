package controller;

public class LibraryController {

    private static LibraryController libraryController;

    public UserController userController;
    public BookController bookController;
    public BorrowController borrowController;

    LibraryController(){
        userController = new UserController();
        bookController = new BookController();
        borrowController = new BorrowController();
    }

    public static LibraryController getInstance(){
        if(libraryController == null)
            libraryController = new LibraryController();
        return libraryController;
    }
}
