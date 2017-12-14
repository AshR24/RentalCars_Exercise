package com.ash.RentalCars_Exercise.parsers;

import com.ash.RentalCars_Exercise.objects.Sipp;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SippLoader
{
    private static final SippLoader INST = new SippLoader();
    private final ArrayList<HashMap<Character, String>> sippDefinitions = new ArrayList<>();

    private SippLoader()
    {
        try
        {
            JSONParser jsonParser = new JSONParser();
            JSONArray root = (JSONArray)jsonParser.parse(new FileReader("src/main/resources/static/sipp.json"));

            for(Object letterNumber : root)
            {
                JSONArray innerList = (JSONArray)letterNumber;
                HashMap<Character, String> listOfDefinitions = new HashMap<>();

                for(Object item : innerList)
                {
                    JSONObject sipp = (JSONObject)item;

                    listOfDefinitions.put(((String)sipp.get("key")).charAt(0), (String)sipp.get("name"));
                }

                sippDefinitions.add(listOfDefinitions);
            }
        }
        catch(ParseException |
                IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public Sipp findSipp(String sippStr)
    {
        HashMap<Integer, String> result = new HashMap<>();

        for(int i = 0; i < sippStr.length(); i++)
        {
            char letter = sippStr.toCharArray()[i];

            if(sippDefinitions.get(i).containsKey(letter))
            {
                String value = sippDefinitions.get(i).get(letter);

                if(i == 1 && !value.contains("doors"))
                {
                    String newType = result.get(1) + " " + value;
                    result.put(1, newType); // Used to merge
                    continue;
                }

                result.put(i + 1, sippDefinitions.get(i).get(letter));
            }
            else if(i == 1 && sippDefinitions.get(0).containsKey(letter)) // If it's not in 2nd column, check the first
            {
                String newType = result.get(1) + " " + sippDefinitions.get(0).get(letter);
                result.put(1, newType); // Used to merge

                //result.put(i + 1, sippDefinitions.get(0).get(letter));
            }
        }

        return new Sipp(sippStr, result);
    }

    public static SippLoader getInstance()
    {
        return INST;
    }
}
