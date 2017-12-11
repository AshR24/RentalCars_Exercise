package parsers;

import objects.Supplier;
import objects.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for parsing a file - Could be expanded in the future to work for other file types (e.g. CSS and XML)
 */
public interface IParser
{
    void openAndParse(String filepath);
    ArrayList<Vehicle> getVehicles();
    HashMap<String, Supplier> getSuppliers();
}
