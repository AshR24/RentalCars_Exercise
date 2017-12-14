package com.ash.RentalCars_Exercise.controllers;

import com.ash.RentalCars_Exercise.parsers.JsonParser;
import com.ash.RentalCars_Exercise.parsers.VehicleParser;
import com.ash.RentalCars_Exercise.tasks.AscendingPrice;
import com.ash.RentalCars_Exercise.tasks.ITask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController
{
    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value = "/get/{taskName}", method = RequestMethod.POST)
    public String getTask(@PathVariable String taskName)
    {

        VehicleParser vehicleParser = new VehicleParser(new JsonParser(), "src/main/resources/static/vehicles.json");

        ITask task = (ITask)appContext.getBean(taskName);

        vehicleParser.performTask(task);
        return task.getJson();
    }
}
