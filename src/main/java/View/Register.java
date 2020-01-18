package View;

import controller.LibraryController;
import model.User;
import utility.Utilities;

import java.sql.Timestamp;
import java.util.Scanner;

public class Register {

    Scanner scanner = new Scanner(System.in);

    public void register() {

        String name;
        String username;
        String password;
        String nationalCode;

        System.out.println("Register : ");

        System.out.println("please enter your name");
        name = scanner.nextLine();

        System.out.println("please enter your username");
        username = scanner.nextLine();

        System.out.println("please enter your password");
        password = scanner.nextLine();

        System.out.println("please enter your national code");
        nationalCode = scanner.nextLine();

        User user = new User(name, username, password, nationalCode, new Timestamp(System.currentTimeMillis()));

        LibraryController.getInstance().userController.register(user);
        Login.currentUser = user;
        System.out.println();
    }
}
