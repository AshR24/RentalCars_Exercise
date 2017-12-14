package com.ash.RentalCars_Exercise.parsers;

import com.ash.RentalCars_Exercise.objects.Sipp;
import com.ash.RentalCars_Exercise.objects.Supplier;
import com.ash.RentalCars_Exercise.objects.Vehicle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonParser implements IParser
{
    private final JSONParser jsonParser = new JSONParser();
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void openAndParse(String filepath)
    {
        try
        {
            JSONObject root = (JSONObject)jsonParser.parse(new FileReader(filepath));

            JSONObject search = (JSONObject)root.get("Search");
            parse((JSONArray)search.get("VehicleList"));
        }
        catch(ParseException |
                IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void parse(JSONArray vehicleList)
    {
        for(Object obj : vehicleList)
        {
            JSONObject item = (JSONObject)obj;

            Vehicle vehicle = new Vehicle((String)item.get("name"),
                    ((Number)item.get("price")).doubleValue()
            );

            Sipp sipp = SippLoader.getInstance().findSipp((String)item.get("sipp"));

            Supplier supplier = new Supplier((String)item.get("supplier"),
                    ((Number)item.get("rating")).doubleValue()
            );

            vehicle.setSipp(sipp);
            vehicle.setSupplier(supplier);

            vehicles.add(vehicle);
        }
    }

    @Override
    public ArrayList<Vehicle> getVehicles()
    {
        return vehicles;
    }
}
