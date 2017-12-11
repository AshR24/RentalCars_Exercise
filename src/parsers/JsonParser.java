package parsers;

import objects.Supplier;
import objects.Vehicle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonParser implements IParser
{
    private final JSONParser jsonParser = new JSONParser();
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final HashMap<String, Supplier> suppliers = new HashMap<>();

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
                    (String)item.get("sipp"),
                    ((Number)item.get("price")).doubleValue()
            );

            Supplier supplier = new Supplier((String)item.get("supplier"),
                    ((Number)item.get("rating")).doubleValue()
            );

            vehicle.setSupplier(supplier);

            vehicles.add(vehicle);
            if(!suppliers.containsKey(supplier.getName()))
            {
                suppliers.put(supplier.getName(), supplier);
            }
        }

        System.out.println("Extracted " + vehicles.size() + " vehicle(s) + " + suppliers.size() + " supplier(s) from .json");
    }

    @Override
    public ArrayList<Vehicle> getVehicles()
    {
        return vehicles;
    }

    @Override
    public HashMap<String, Supplier> getSuppliers()
    {
        return suppliers;
    }
}
