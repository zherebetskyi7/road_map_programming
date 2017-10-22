package enterDataFromConsole.sumOfElementsInArray;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumArrayElements
{
    public static void sumOfAllElementsInArray()
    {
        Scanner scan = new Scanner(System.in);
        int sum_handle = 0;
        int sum_function = 0;

        System.out.println("Please enter length of array (integer): ");
        int array_length = scan.nextInt();
        int[] numbers = new int[array_length];
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println("Please enter a number (integer): ");
            numbers[i] = scan.nextInt();
        }
        for (int i = 0; i < numbers.length; i++)
        {
            sum_handle += numbers[i];
        }
        System.out.println("Sum of array elements: " + sum_handle);
        System.out.println("Sum of array elements (function): " + IntStream.of(numbers).sum());
    }
}
