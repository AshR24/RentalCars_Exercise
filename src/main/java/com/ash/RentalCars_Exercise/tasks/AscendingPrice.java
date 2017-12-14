package com.ash.RentalCars_Exercise.tasks;

import com.ash.RentalCars_Exercise.objects.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class AscendingPrice extends baseTask
{
    /**
     * Sorts vehicles by price ascending
     */
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
