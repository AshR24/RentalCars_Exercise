import parsers.VehicleParser;

public class Driver
{
    public static void main(String[] args)
    {
        VehicleParser vParser = new VehicleParser();
        vParser.parse("vehicles.json");
    }
}
