package com.ash.RentalCars_Exercise.tasks;

import com.ash.RentalCars_Exercise.objects.Sipp;
import com.ash.RentalCars_Exercise.objects.Supplier;
import com.ash.RentalCars_Exercise.objects.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;

@Component
public class HighestRatedSupplierByCarType extends baseTask
{
    /**
     * Sorts vehicles by highest supplier per car type
     */
    @Override
    public void start()
    {
        Comparator<Vehicle> byType = Comparator.comparing((Vehicle v)->v.getSipp().getCarType());
        Comparator<Vehicle> byRating = Comparator.comparing((Vehicle v)->v.getSupplier().getRating()).reversed();

        vehicles.sort(byType
            .thenComparing(byRating));

        ArrayList<String> typesAlreadyFound = new ArrayList<>();
        ArrayList<Vehicle> sortedList = new ArrayList<>();

        // Gets the first instance of each car type
        vehicles.forEach(vehicle ->
        {
            Sipp sipp = vehicle.getSipp();

            if(!typesAlreadyFound.contains(sipp.getCarType()))
            {
                typesAlreadyFound.add(sipp.getCarType());
                sortedList.add(vehicle);
            }
        });

        sortedList.sort(byRating);

        sortedList.forEach(vehicle ->
        {
            Supplier supplier = vehicle.getSupplier();

            addResult(new TaskResult(this.getClass().getSimpleName(),
                    vehicle.getName(),
                    vehicle.getSipp().getCarType(),
                    supplier.getName(),
                    String.valueOf(supplier.getRating()))
            );
        });
    }
}
