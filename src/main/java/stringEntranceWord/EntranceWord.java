package stringEntranceWord;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EntranceWord
{
    public static void enterString()
    {
        Scanner scan = new Scanner(System.in);
        int number = 0;

        System.out.println("Please enter a string: ");
        String long_string = scan.nextLine();
        String[] arrString = long_string.split(" ");
        System.out.println("Please enter a word that you want to check: ");
        String check_word = scan.next();
        for (int i = 0; i < arrString.length; i++)
        {
            if (arrString[i].equals(check_word))
            {
                number += 1;
            }
        }
        if (number == 0)
        {
            System.out.println("No '" + check_word + "' word in this string");
        }
        else
        {
            System.out.println(number);
        }
    }
}
