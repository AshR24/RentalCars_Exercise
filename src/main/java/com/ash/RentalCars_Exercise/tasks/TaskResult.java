package com.ash.RentalCars_Exercise.tasks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Used to export a tasks results (dynamic size)
 */
public class TaskResult
{
    private final String taskName;
    private int id = 0;
    private ArrayList<String> items = new ArrayList<>();

    /**
     * Takes results and adds them to a list (dynamic, not fixed size)
     * @param taskName
     * @param results
     */
    public TaskResult(String taskName, String... results)
    {
        this.taskName = taskName;
        items.addAll(Arrays.asList(results));
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    /**
     * Converts the list into a readable format
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        //strBuilder.append(id);
                //.append(".   ");

        //strBuilder.append("\"");

        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i) == null) { continue; }

            /*strBuilder.append("{")
                    .append(items.get(i))
                    .append("}");*/
            strBuilder.append(items.get(i));

            if(i != items.size() - 1)
            {
                //strBuilder.append("-");
                strBuilder.append(", ");
            }
        }

        //strBuilder.append("\"");

        //strBuilder.append(" \n");

        return strBuilder.toString();
    }
}
