package enterDataFromConsole.differenceBetweenDates;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DifferrenceDateClass
{

    public static void difference() throws ParseException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter bigger date in the format yyyy-MM-dd");
        String line1 = scan.nextLine();
        System.out.println("Enter smaller date in the format yyyy-MM-dd");
        String line2 = scan.nextLine();
        difference_function(line1, line2);
    }

    public static void difference_json() throws IOException, org.json.simple.parser.ParseException, ParseException
    {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/9th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        String line1 = (String) jsonObject.get("date1");
        String line2 = (String) jsonObject.get("date2");

        difference_function(line1, line2);
    }

    private static void difference_function(String line1, String line2) throws ParseException
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date date1 = format.parse(line1);
        Date date2 = format.parse(line2);

        int diffInDays = (int)( (date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24) );

        if (diffInDays <= 0)
        {
            diffInDays = diffInDays - diffInDays*2;
        }

        System.out.println("Difference is " + diffInDays + " days");
    }
}
