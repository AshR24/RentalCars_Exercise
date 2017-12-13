package tasks;

import objects.Vehicle;

import java.util.ArrayList;

public abstract class baseTask implements ITask
{
    private final ArrayList<TaskResult> results = new ArrayList<>();

    protected ArrayList<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void loadData(ArrayList<Vehicle> vehicles)
    {
        this.vehicles = new ArrayList<>(vehicles);
        results.clear();
    }

    @Override
    public ArrayList<TaskResult> getResults()
    {
        return results;
    }

    @Override
    public String getReadableResults()
    {
        StringBuilder strBuilder = new StringBuilder();

        for(TaskResult res : results)
        {
            strBuilder.append(res);
        }

        return strBuilder.toString();
    }

    @Override
    public void addResult(TaskResult result)
    {
        result.setId(results.size() + 1);
        results.add(result);
    }
}
