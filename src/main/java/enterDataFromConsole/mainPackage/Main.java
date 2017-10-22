package enterDataFromConsole.mainPackage;

import enterDataFromConsole.ageAndPulse.Formula;
import enterDataFromConsole.differenceBetweenDates.DifferrenceDateClass;
import enterDataFromConsole.downloadAllPictures.DownloadPicturesClass;
import enterDataFromConsole.minAndMaxElementInArray.MinAndMax;
import enterDataFromConsole.palindromString.PalindromeClass;
import enterDataFromConsole.parseTwitterAccount.ParseTwitterClass;
import enterDataFromConsole.password.PasswordClass;
import enterDataFromConsole.programmersDay.ProgrammersDayClass;
import enterDataFromConsole.removeSpaceFromString.RemoveSpaceFromString;
import enterDataFromConsole.htmlConvertToPdf.HttpDownloadUtility;
import enterDataFromConsole.sameElementsIn2Arrays.SameElements;
import enterDataFromConsole.stringEntranceWord.EntranceWord;
import enterDataFromConsole.sumOfElementsInArray.SumArrayElements;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        do
        {
            System.out.println("Enter 1  - first task");
            System.out.println("Enter 2  - second task");
            System.out.println("Enter 3  - third task");
            System.out.println("Enter 4  - fourth task");
            System.out.println("Enter 5  - fifth task");
            System.out.println("Enter 6  - sixth task");
            System.out.println("Enter 7  - seventh task");
            System.out.println("Enter 8  - eighth task");
            System.out.println("Enter 9  - ninth task");
            System.out.println("Enter 10 - tenth task");
            System.out.println("Enter 11 - eleventh task");
            System.out.println("Enter 12 - twelfth task");
            System.out.println("Enter 13 - thirteenth task");
            System.out.println("Enter 14 - exit");
            System.out.println("Please enter a number of task and click ENTER");
            number = scan.nextInt();
            switch (number)
            {
                case 1:
                    Formula.formula();
                    break;
                case 2:
                    SumArrayElements.sumOfAllElementsInArray();
                    break;
                case 3:
                    MinAndMax.minAndMaxElementInArray();
                    break;
                case 4:
                    SameElements.sameElementsInArrays();
                    break;
                case 5:
                    EntranceWord.enterString();
                    break;
                case 6:
                    RemoveSpaceFromString.remove_space();
                    break;
                case 7:
                    PalindromeClass.checkPalindrome();
                    break;
                case 8:
                    PasswordClass.checkPassword();
                    break;
                case 9:
                    DifferrenceDateClass.difference();
                    break;
                case 10:
                    ProgrammersDayClass.day_of_programmer();
                    break;
                case 11:
                    ParseTwitterClass.oneHundredTweets();
                    break;
                case 12:
                    DownloadPicturesClass.download();
                    break;
                case 13:
                    HttpDownloadUtility.download();
                    break;
                default:
                        System.out.println("Wrong number, please choose one from list");
                        break;
            }
        }while(number != 14);
    }
}
