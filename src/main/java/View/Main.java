package View;


public class Main {
    static Login login = new Login();
    static Register register = new Register();
    static BorrowView borrowView = new BorrowView();

    public static void main(String[] args) {

        register.register();
        login.login();
        borrowView.borrowView();
        borrowView.refund();
    }
}
