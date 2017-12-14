package com.ash.RentalCars_Exercise;

import com.ash.RentalCars_Exercise.parsers.JsonParser;
import com.ash.RentalCars_Exercise.parsers.VehicleParser;
import com.ash.RentalCars_Exercise.tasks.*;

public class Driver
{
    public static void main(String[] args)
    {
        VehicleParser vParser = new VehicleParser(new JsonParser(), "static/vehicles.json");

        ITask task = new AscendingPrice();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());

        task = new CalculateSpecification();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());

        task = new HighestRatedSupplierByCarType();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());

        task = new VehicleScores();
        vParser.performTask(task);
        System.out.println(task.getJson());
    }
}
