package enterDataFromConsole.password;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        try
        {
            if (checkWithRegExp(password))
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
        catch (InputMismatchException e)
        {
            System.out.println("Wrong symbols, you can input only upper/lower case, numbers and '_'");
        }
    }

    public static void checkPasswordJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/8th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        String password = (String) jsonObject.get("password");
        try
        {
            if (checkWithRegExp(password))
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
        catch (InputMismatchException e)
        {
            System.out.println("Wrong symbols, you can input only upper/lower case, numbers and '_'");
        }
    }

    private static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^(?=.*[a-z0-9_])(?=.*[A-Z])[A-z0-9_]{8,}$");//("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9_]).{8,}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
