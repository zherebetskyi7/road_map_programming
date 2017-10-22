package enterDataFromConsole.stringEntranceWord;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        System.out.println("Please enter a string: ");
        String long_string = scan.nextLine();

        System.out.println("Please enter a word that you want to check: ");
        String check_word = scan.next();

        magic_with_strings(long_string, check_word);
    }

    public static void enter_string_from_json() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/5th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        String long_string = (String) jsonObject.get("string");
        String check_word = (String) jsonObject.get("word");

        magic_with_strings(long_string, check_word);
    }

    private static void magic_with_strings(String long_string, String check_word)
    {
        int number = 0;
        String[] arrString = long_string.split(" ");
        for (int i = 0; i < arrString.length; i++)
        {
            if (arrString[i].equals(check_word))
            {
                number += 1;
            }
        }
        if (number == 0)
        {
           String no_words = "No '" + check_word + "' word in this string";
           System.out.println(no_words);
        }
        else
        {
            System.out.println(check_word + " = " + number);
        }
    }
}
