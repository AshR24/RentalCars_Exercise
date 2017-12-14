package com.ash.RentalCars_Exercise.controllers;

import com.ash.RentalCars_Exercise.parsers.JsonParser;
import com.ash.RentalCars_Exercise.parsers.VehicleParser;
import com.ash.RentalCars_Exercise.tasks.ITask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController
{
    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value = "/{taskName}", method = RequestMethod.GET)
    public String getTask(@PathVariable String taskName)
    {
        VehicleParser vehicleParser = new VehicleParser(new JsonParser(), "static/vehicles.json");

        ITask task = (ITask)appContext.getBean(taskName); // Finds relevant task class using name

        vehicleParser.performTask(task);
        return task.getJson();
    }
}
