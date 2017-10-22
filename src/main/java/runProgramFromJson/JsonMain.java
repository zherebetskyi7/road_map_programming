package runProgramFromJson;

import enterDataFromConsole.ageAndPulse.Formula;
import enterDataFromConsole.differenceBetweenDates.DifferrenceDateClass;
import enterDataFromConsole.downloadAllPictures.DownloadPicturesClass;
import enterDataFromConsole.htmlConvertToPdf.HttpDownloadUtility;
import enterDataFromConsole.minAndMaxElementInArray.MinAndMax;
import enterDataFromConsole.minAndMaxElementInArray.MinAndMaxList;
import enterDataFromConsole.palindromString.PalindromeClass;
import enterDataFromConsole.parseTwitterAccount.ParseTwitterClass;
import enterDataFromConsole.password.PasswordClass;
import enterDataFromConsole.programmersDay.ProgrammersDayClass;
import enterDataFromConsole.removeSpaceFromString.RemoveSpaceFromString;
import enterDataFromConsole.sameElementsIn2Arrays.SameElements;
import enterDataFromConsole.sameElementsIn2Arrays.SameElementsList;
import enterDataFromConsole.stringEntranceWord.EntranceWord;
import enterDataFromConsole.sumOfElementsInArray.SumArrayElements;
import enterDataFromConsole.sumOfElementsInArray.SumArrayElementsList;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static java.lang.Math.toIntExact;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class JsonMain
{
    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();

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
                    Object object1 = parser.parse(new FileReader("src/main/java/runProgramFromJson/1st_task.json"));
                    JSONObject jsonObject1 = (JSONObject)object1;
                    int age = toIntExact((Long) jsonObject1.get("age"));
                    int pulse = toIntExact((Long) jsonObject1.get("pulse"));
                    System.out.println(Formula.age_and_pulse_formula(age, pulse));
                    break;
                case 2:
                    System.out.println(SumArrayElementsList.sum());
                    break;
                case 3:
                    MinAndMaxList.numbers();
                    break;
                case 4:
                    SameElementsList.same_elements_json();
                    break;
                case 5:
                    EntranceWord.enter_string_from_json();
                    break;
                case 6:
                    RemoveSpaceFromString.remove_space_json();
                    break;
                case 7:
                    PalindromeClass.checkPalindromeJson();
                    break;
                case 8:
                    PasswordClass.checkPasswordJson();
                    break;
                case 9:
                    DifferrenceDateClass.difference_json();
                    break;
                case 10:
                    ProgrammersDayClass.day_of_programmer_json();
                    break;
                case 11:
                    ParseTwitterClass.oneHundredTweets();
                    break;
                case 12:
                    DownloadPicturesClass.download_json();
                    break;
                case 13:
                    HttpDownloadUtility.download_json();
                    break;
                default:
                    System.out.println("Wrong number, please choose one from list");
                    break;
            }
        }while(number != 14);
    }
}
