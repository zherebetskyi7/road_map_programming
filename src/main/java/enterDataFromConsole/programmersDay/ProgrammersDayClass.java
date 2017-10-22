package enterDataFromConsole.programmersDay;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.toIntExact;

public class ProgrammersDayClass
{
    public static void day_of_programmer() throws ParseException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a year: ");
        int year = scan.nextInt();

        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            String intercalaryYear = Integer.toString(year) + "-09-12";
            System.out.println(date(intercalaryYear));

        }
        else
        {
            String normalYear = Integer.toString(year) + "-09-13";
            System.out.println(date(normalYear));
        }
    }

    public static void day_of_programmer_json() throws IOException, org.json.simple.parser.ParseException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/10th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        int year = toIntExact((Long) jsonObject.get("year"));

        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            String intercalaryYear = Integer.toString(year) + "-09-12";
            System.out.println(date(intercalaryYear));

        }
        else
        {
            String normalYear = Integer.toString(year) + "-09-13";
            System.out.println(date(normalYear));
        }
    }

    private static String date(String line) throws ParseException
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(line);
        SimpleDateFormat format2 = new SimpleDateFormat("EEE dd    MMM yyyy");
        String result = format2.format(date1);

        return result;
    }
}
