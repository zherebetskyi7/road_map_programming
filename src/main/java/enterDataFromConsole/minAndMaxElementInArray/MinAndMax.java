package enterDataFromConsole.minAndMaxElementInArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang.ArrayUtils;


public class MinAndMax
{
    public static void minAndMaxElementInArray()
    {
        Scanner scan = new Scanner(System.in);
        int min_element = 0;
        int max_element = 0;

        System.out.println("Please enter a length of array (integer): ");
        int array_length = scan.nextInt();
        int[] numbers = new int[array_length];
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println("Please enter a number (integer): ");
            numbers[i] = scan.nextInt();
        }
        Arrays.sort(numbers);
        List b = Arrays.asList(ArrayUtils.toObject(numbers));
        System.out.println("Min element: " + numbers[0] + ", " + "Max element: " + numbers[numbers.length-1]);
        System.out.println("(Function) Min element: " + Collections.min(b) + ", " + "Max element: " + Collections.max(b));
    }
}
