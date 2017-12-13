package parsers;

import tasks.ITask;

public class VehicleParser
{
    private final IParser parser;

    public VehicleParser(IParser parser)
    {
        this.parser = parser;
    }

    public void parse(String filepath)
    {
        parser.openAndParse(filepath);
    }

    public <T extends ITask> void performTask(T task)
    {
        task.loadData(parser.getVehicles());
        task.start();
    }
}
