package palindromString;

import java.util.Scanner;

public class PalindromeClass
{
    public static void checkPalindrome()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a word to check if word is palindrome: ");
        String word = scan.nextLine();
        char[] wordArr = new char[word.length()];
        for (int i = 0; i < wordArr.length; i++)
        {
            wordArr[i] = word.charAt(i);
        }
        System.out.println(istPalindrom(wordArr));
    }

    private static boolean istPalindrom(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
