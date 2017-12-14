package com.ash.RentalCars_Exercise.tasks;

import com.ash.RentalCars_Exercise.objects.Vehicle;

import java.util.ArrayList;

public interface ITask
{
    void loadData(ArrayList<Vehicle> vehicles);
    void start();
    ArrayList<TaskResult> getResults();
    String getReadableResults();
    String getJson();
    void addResult(TaskResult result);
}
