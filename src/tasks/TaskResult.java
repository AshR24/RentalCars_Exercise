package tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskResult
{
    private final String taskName;
    private int id = 0;
    private ArrayList<String> items = new ArrayList<>();

    public TaskResult(String taskName, String... results)
    {
        this.taskName = taskName;
        items.addAll(Arrays.asList(results));
    }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(id)
                .append(".   ");

        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i) == null) { continue; }

            strBuilder.append("{")
                    .append(items.get(i))
                    .append("}");

            if(i != items.size() - 1)
            {
                strBuilder.append("-");
            }
        }

        strBuilder.append("\n");

        return strBuilder.toString();
    }
}
