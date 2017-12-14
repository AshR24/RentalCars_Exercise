package com.ash.RentalCars_Exercise.tasks;

import com.ash.RentalCars_Exercise.objects.Sipp;
import org.springframework.stereotype.Component;

@Component
public class CalculateSpecification extends baseTask
{
    @Override
    public void start()
    {
        vehicles.forEach(vehicle ->
        {
            Sipp sipp = vehicle.getSipp();

            addResult(new TaskResult(this.getClass().getSimpleName(),
                    vehicle.getName(),
                    sipp.getSippStr(),
                    sipp.getCarType(),
                    sipp.getDoors(),
                    sipp.getTransmission(),
                    sipp.getFuel(),
                    sipp.getAirCon())
            );
        });
    }
}
