package sameElementsIn2Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SameElements
{
    public static void sameElementsInArrays()
    {
        Scanner scan = new Scanner(System.in);
        char element;

        System.out.println("Please enter a length of array 1 (integer): ");
        int array_length_1 = scan.nextInt();
        char[] array1 = new char[array_length_1];
        char[] array2 = new char[array_length_1];
        List<Character> similar_elements = new ArrayList<Character>();
        // enter numbers to array 1
        for (int i = 0; i < array1.length; i++)
        {
            System.out.println("Please enter an element of array 1: ");
            array1[i] = scan.next().charAt(0);
        }
        // enter numbers to array 2
        for (int i = 0; i < array2.length; i++)
        {
            System.out.println("Please enter an element of array 2: ");
            array2[i] = scan.next().charAt(0);
        }
        // check similar elements
        for (int i = 0; i < array1.length; i++)
        {
            element = array1[i];
            for (int k = 0; k < array2.length; k++)
            {
                if (element == array2[k])
                {
                    similar_elements.add(element);
                }
            }
        }
        if (similar_elements.isEmpty())
        {
            System.out.println("No Same elements in the list");
        }
        else
        {
            System.out.println("Same elements: " + similar_elements);
        }
    }
}
