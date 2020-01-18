package View;

import controller.LibraryController;
import model.User;
import utility.Utilities;

import java.util.Scanner;

public class Login {

    public static User currentUser;
    public static boolean isLoggedIn;
    Scanner scanner = new Scanner(System.in);

    public void login() {

        String username;
        String password;

        System.out.println("Login : ");

        System.out.println("please enter your username");
        username = scanner.nextLine();

        System.out.println("please enter your password");
        password = scanner.nextLine();

        User user = LibraryController.getInstance().userController.login(username, password);

        if(user != null) {
            isLoggedIn = true;
            System.out.println("you logged in");
            currentUser = user;
        }
        else
            System.out.println("username or password is wrong");

        System.out.println();

//        System.out.println((currentUser!=null ? "now you are login":"username or password is wrong"));
    }
}
