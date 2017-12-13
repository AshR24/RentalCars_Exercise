package parsers;

import objects.Vehicle;

import java.util.ArrayList;

/**
 * Interface for parsing a file - Could be expanded in the future to work for other file types (e.g. CSS and XML)
 */
public interface IParser
{
    void openAndParse(String filepath);
    ArrayList<Vehicle> getVehicles();
}
