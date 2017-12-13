package tasks;

import objects.Vehicle;

import java.util.Comparator;

public class AscendingPrice extends baseTask
{
    @Override
    public void start()
    {
        Comparator<Vehicle> byPrice = Comparator.comparing(Vehicle::getPrice);

        vehicles.sort(byPrice);

        vehicles.forEach(vehicle ->
        {
            addResult(new TaskResult(this.getClass().getSimpleName(),
                    vehicle.getName(),
                    String.valueOf(vehicle.getPrice())
            ));
        });
    }
}
