package tasks;

import objects.Vehicle;

import java.util.ArrayList;

public interface ITask
{
    void loadData(ArrayList<Vehicle> vehicles);
    void start();
    ArrayList<TaskResult> getResults();
    String getReadableResults();
    void addResult(TaskResult result);
}
