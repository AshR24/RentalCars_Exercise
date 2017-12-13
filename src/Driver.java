import parsers.JsonParser;
import parsers.VehicleParser;
import tasks.*;

public class Driver
{
    public static void main(String[] args)
    {
        VehicleParser vParser = new VehicleParser(new JsonParser());
        vParser.parse("res/vehicles.json");

        ITask task = new AscendingPrice();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());

        task = new CalculateSpecification();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());

        task = new HighestRatedSupplierByCarType();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());

        task = new VehicleScores();
        vParser.performTask(task);
        System.out.println(task.getReadableResults());
    }
}
