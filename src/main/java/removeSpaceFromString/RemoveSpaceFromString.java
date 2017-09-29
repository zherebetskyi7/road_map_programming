package removeSpaceFromString;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveSpaceFromString
{
    public static void remove_space()
    {
        Scanner scan = new Scanner(System.in);
        String without_space_string = "";

        System.out.println("Please enter a string: ");
        String with_space_string = scan.nextLine();
        String[] arrString = with_space_string.split(" ");
        for (int i = 0; i < arrString.length; i++)
        {
            without_space_string += arrString[i];
        }
        System.out.println("Remove space throw array split: " + without_space_string);
        System.out.println("Remove space with regex: " + with_space_string.replaceAll("\\s",""));
    }
}
