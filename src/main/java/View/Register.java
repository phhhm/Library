package View;

import model.User;

import java.sql.Timestamp;
import java.util.Scanner;

public class Register {

    public void register() {

        String name;
        String username;
        String password;
        String nationalCode;

        Scanner scanner = new Scanner(System.in);

        System.out.println("welcome");
        System.out.println("please enter your name");
        name = scanner.nextLine();
        System.out.println("please enter your username");
        username = scanner.nextLine();
        System.out.println("please enter your password");
        password = scanner.nextLine();
        System.out.println("please enter your national code");
        nationalCode = scanner.nextLine();

        User user = new User(name, username, password, nationalCode, new Timestamp(System.currentTimeMillis()));

        Login.userController.register(user);
        Login.currentUser = user;
    }
}
