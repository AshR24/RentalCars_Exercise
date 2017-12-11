package parsers;

import objects.Supplier;
import objects.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleParser
{
    private final IParser parser;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private HashMap<String, Supplier> suppliers = new HashMap<>();

    public VehicleParser()
    {
        parser = new JsonParser();
    }

    public void parse(String filepath)
    {
        vehicles.clear();
        suppliers.clear();

        parser.openAndParse(filepath);
        vehicles = parser.getVehicles();
        suppliers = parser.getSuppliers();

        System.out.println();
    }
}
