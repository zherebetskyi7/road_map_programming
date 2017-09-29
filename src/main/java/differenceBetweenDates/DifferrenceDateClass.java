package differenceBetweenDates;

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
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        System.out.println("Enter bigger date in the format yyyy-MM-dd");
        String line1 = scan.nextLine();
        System.out.println("Enter smaller date in the format yyyy-MM-dd");
        String line2 = scan.nextLine();

        Date date1 = format.parse(line1);
        Date date2 = format.parse(line2);

        int diffInDays = (int)( (date1.getTime() - date2.getTime())
                / (1000 * 60 * 60 * 24) );

        System.out.println("Difference is " + diffInDays + " days");
    }
}
