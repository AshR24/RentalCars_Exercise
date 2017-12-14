package com.ash.RentalCars_Exercise.parsers;

import com.ash.RentalCars_Exercise.tasks.ITask;

public class VehicleParser
{
    private final IParser parser;

    public VehicleParser(IParser parser, String filepath)
    {
        this.parser = parser;
        parser.openAndParse(filepath);
    }

    /**
     * Loads and executes a given ITask
     * @param task
     * @param <T>
     */
    public <T extends ITask> void performTask(T task)
    {
        task.loadData(parser.getVehicles());
        task.start();
    }
}
