package com.ash.RentalCars_Exercise.parsers;

import com.ash.RentalCars_Exercise.objects.Sipp;
import com.ash.RentalCars_Exercise.objects.Supplier;
import com.ash.RentalCars_Exercise.objects.Vehicle;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonParser implements IParser
{
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void openAndParse(String filepath)
    {
        try
        {
            ClassPathResource resource = new ClassPathResource(filepath);
            InputStream inputStream = resource.getInputStream();

            byte[] jsonData = new byte[inputStream.available()];
            inputStream.read(jsonData);

            JsonNode rootNode = new ObjectMapper().readTree(jsonData);
            JsonNode vehicleList = rootNode.findPath("VehicleList");

            vehicleList.forEach(jsonNode ->
            {
                Vehicle vehicle = new Vehicle(jsonNode.get("name").asText(), jsonNode.get("price").asDouble());
                Sipp sipp = SippLoader.getInstance().findSipp(jsonNode.get("sipp").asText());
                Supplier supplier = new Supplier(jsonNode.get("supplier").asText(), jsonNode.get("rating").asDouble());

                vehicle.setSipp(sipp);
                vehicle.setSupplier(supplier);

                vehicles.add(vehicle);
            });
        }
        catch(IOException ex) { ex.printStackTrace(); }
    }

    @Override
    public ArrayList<Vehicle> getVehicles()
    {
        return vehicles;
    }
}
