package utility;

import java.util.Scanner;

public class Utilities {

    private static Utilities utilities ;
    private Scanner scanner;

    Utilities(){
        scanner = new Scanner(System.in);
    }

    public static Utilities getInstance(){
        if(utilities == null)
            utilities = new Utilities();
        return utilities;
    }

    public Integer getIntFromUser(){
        return scanner.nextInt();
    }

    public String getStringFromUser(){
        return scanner.nextLine();
    }

    public Long getLongFromUser(){
        return scanner.nextLong();
    }
}
