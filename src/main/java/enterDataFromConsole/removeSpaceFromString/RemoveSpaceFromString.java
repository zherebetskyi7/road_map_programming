package enterDataFromConsole.removeSpaceFromString;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveSpaceFromString
{

    public static void remove_space()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a string: ");
        String with_space_string = scan.nextLine();

        remove_space_function(with_space_string);
    }

    public static void remove_space_json() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/6th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        String string = (String) jsonObject.get("string");

        remove_space_function(string);
    }

    private static void remove_space_function(String with_space_string)
    {
        String without_space_string = "";

        String[] arrString = with_space_string.split(" ");
        for (int i = 0; i < arrString.length; i++)
        {
            without_space_string += arrString[i];
        }
        System.out.println("Remove space throw array split: " + without_space_string);
        System.out.println("Remove space with regex: " + with_space_string.replaceAll("\\s",""));
    }
}
