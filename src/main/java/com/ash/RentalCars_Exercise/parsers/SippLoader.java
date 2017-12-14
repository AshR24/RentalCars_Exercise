package com.ash.RentalCars_Exercise.parsers;

import com.ash.RentalCars_Exercise.objects.Sipp;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class SippLoader
{
    private static final SippLoader INST = new SippLoader();
    private final ArrayList<HashMap<Character, String>> sippDefinitions = new ArrayList<>();

    /**
     * Loads relevant SIPP classifiers from parsing the given sipp.json
     */
    private SippLoader()
    {
        try
        {
            ClassPathResource resource = new ClassPathResource("static/sipp.json");
            InputStream inputStream = resource.getInputStream();

            byte[] jsonData = new byte[inputStream.available()];
            inputStream.read(jsonData);

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(jsonData);
            System.out.println();

            for(JsonNode outer : rootNode)
            {
                HashMap<Character, String> listOfDefinitions = new HashMap<>();

                for(JsonNode inner : outer)
                {
                    listOfDefinitions.put(inner.get("key").asText().charAt(0), inner.get("name").asText());
                }

                sippDefinitions.add(listOfDefinitions);
            }
        }
        catch(IOException ex) { ex.printStackTrace(); }
    }

    /**
     * Parses a given SIPP code and returns a sipp class containing the definitions
     * @param sippStr
     * @return
     */
    public Sipp findSipp(String sippStr)
    {
        HashMap<Integer, String> result = new HashMap<>();

        for(int i = 0; i < sippStr.length(); i++)
        {
            char letter = sippStr.toCharArray()[i];

            if(sippDefinitions.get(i).containsKey(letter))
            {
                String value = sippDefinitions.get(i).get(letter);

                // If the 2nd letter doesn't contain "doors" - add it to the first result
                if(i == 1 && !value.contains("doors"))
                {
                    String newType = result.get(1) + " " + value;
                    result.put(1, newType); // Merges with first result
                    continue;
                }

                result.put(i + 1, sippDefinitions.get(i).get(letter));
            }
            else if(i == 1 && sippDefinitions.get(0).containsKey(letter)) // If it's not in 2nd column, check the first (for the X - Special case)
            {
                String newType = result.get(1) + " " + sippDefinitions.get(0).get(letter);
                result.put(1, newType); // Merges with first result
            }
        }

        return new Sipp(sippStr, result);
    }

    public static SippLoader getInstance()
    {
        return INST;
    }
}
