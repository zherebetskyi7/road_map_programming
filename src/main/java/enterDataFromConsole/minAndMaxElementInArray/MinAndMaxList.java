package enterDataFromConsole.minAndMaxElementInArray;

import org.apache.commons.lang.ArrayUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.toIntExact;

public class MinAndMaxList
{
    public static void numbers() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/3rd_task.json"));
        JSONObject jsonObject = (JSONObject)object;
        JSONArray arr = (JSONArray) jsonObject.get("arr_elements");

        int size = arr.size();

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++)
        {
            numbers[i] = toIntExact((Long) arr.get(i));
        }
        Arrays.sort(numbers);
        List b = Arrays.asList(ArrayUtils.toObject(numbers));
        System.out.println("Min element: " + numbers[0] + ", " + "Max element: " + numbers[numbers.length-1]);
        System.out.println("(Function) Min element: " + Collections.min(b) + ", " + "Max element: " + Collections.max(b));
    }

}
