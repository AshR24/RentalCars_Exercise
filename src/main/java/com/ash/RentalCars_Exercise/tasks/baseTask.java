package com.ash.RentalCars_Exercise.tasks;

import com.ash.RentalCars_Exercise.objects.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class baseTask implements ITask
{
    private final ArrayList<TaskResult> results = new ArrayList<>();

    protected ArrayList<Vehicle> vehicles = new ArrayList<>();

    /**
     * Loads the task with a local copy of the vehicles
     * @param vehicles
     */
    @Override
    public void loadData(ArrayList<Vehicle> vehicles)
    {
        this.vehicles = new ArrayList<>(vehicles);
        results.clear();
    }

    /**
     * Returns a list of task results
     * @return
     */
    @Override
    public ArrayList<TaskResult> getResults()
    {
        return results;
    }

    /**
     * Returns a string of task results
     * @return
     */
    @Override
    public String getReadableResults()
    {
        StringBuilder strBuilder = new StringBuilder();

        for(TaskResult res : results)
        {
            strBuilder.append(res).append("\n");
        }

        return strBuilder.toString();
    }

    /**
     * Returns task results in json format
     * @return
     */
    @Override
    public String getJson()
    {
        ObjectMapper mapper = new ObjectMapper();

        ArrayNode arrayNode = mapper.createArrayNode();

        AtomicInteger counter = new AtomicInteger();
        results.forEach(taskResult ->
        {
            ObjectNode objNode = mapper.createObjectNode();
            objNode.put(String.valueOf(counter.getAndIncrement()), taskResult.toString());

            arrayNode.add(objNode);
        });

        /*JSONArray array = new JSONArray();

        array.addAll(results);

        return array.toJSONString();*/

        return arrayNode.toString();
    }

    /**
     * Adds a task result to final results
     * @param result
     */
    @Override
    public void addResult(TaskResult result)
    {
        result.setId(results.size() + 1);
        results.add(result);
    }
}
