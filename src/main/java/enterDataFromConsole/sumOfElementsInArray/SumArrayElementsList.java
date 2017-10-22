package enterDataFromConsole.sumOfElementsInArray;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

public class SumArrayElementsList
{
    public static Integer sum() throws IOException, ParseException
    {
        int sum_elements = 0;
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/2nd_task.json"));
        JSONObject jsonObject = (JSONObject)object;
        JSONArray arr = (JSONArray) jsonObject.get("arr_elements");

        int size = arr.size();

        for (int i = 0; i < size; i++)
        {
            sum_elements += toIntExact((Long) arr.get(i));
        }

        return sum_elements;
    }
}
