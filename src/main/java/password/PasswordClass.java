package password;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordClass
{
    public static void checkPassword() throws InputMismatchException
    {
        Scanner scan = new Scanner(System.in);
        int count = 0;

        System.out.println("Please enter your password:");
        String password = scan.nextLine();
        if (checkWithRegExp(password) == true)
        {
            System.out.println("Good password");
        }
        else
        {
            System.out.println("Your password should contain one upper, one small and one digit symbol, " +
                    "also sum of characters should be 8 or more");
        }
        System.out.println(checkWithRegExp(password));
    }

    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^[a-zA-Z0-9_]((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,})$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
