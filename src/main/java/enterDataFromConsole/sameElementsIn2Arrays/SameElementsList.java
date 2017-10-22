package enterDataFromConsole.sameElementsIn2Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

public class SameElementsList
{
    public static void same_elements_json() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/4th_task.json"));
        JSONObject jsonObject = (JSONObject)object;
        JSONArray arr_1 = (JSONArray) jsonObject.get("arr_elements_1");
        JSONArray arr_2 = (JSONArray) jsonObject.get("arr_elements_2");

        int element;
        List<Integer> similar_elements = new ArrayList<Integer>();

        for (int i = 0; i < arr_1.size(); i++)
        {
            element = toIntExact((Long) arr_1.get(i));
            for (int k = 0; k < arr_2.size(); k++)
            {
                if (element == toIntExact((Long) arr_2.get(k)))
                {
                    similar_elements.add(element);
                    break;
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
