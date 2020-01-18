package View;

import controller.UserController;
import model.User;
import utility.Utilities;

public class Login {

    public static UserController userController = new UserController();
    public static User currentUser;
    public static boolean isLogedIn;

    public void login() {

        String username;
        String password;

        System.out.println("welcom");

        System.out.println("please enter your username");
        username = Utilities.getInstance().getStringFromUser();

        System.out.println("please enter your password");
        password = Utilities.getInstance().getStringFromUser();

        User user = userController.login(username, password);

        if(user != null) {
            isLogedIn = true;
            System.out.println("you logged in");
        }
        else
            System.out.println("username or password is wrong");

//        System.out.println((currentUser!=null ? "now you are login":"username or password is wrong"));
    }
}
