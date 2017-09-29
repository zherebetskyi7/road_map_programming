package programmersDay;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

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

    private static String date(String line) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(line);
        SimpleDateFormat format2 = new SimpleDateFormat("EEE dd    MMM yyyy");
        String result = format2.format(date1);

        return result;
    }
}
