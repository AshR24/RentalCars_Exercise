package tasks;

import objects.Sipp;
import objects.Supplier;
import objects.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;

public class HighestRatedSupplierByCarType extends baseTask
{
    @Override
    public void start()
    {
        Comparator<Vehicle> byType = Comparator.comparing((Vehicle v)->v.getSipp().getCarType());
        Comparator<Vehicle> byRating = Comparator.comparing((Vehicle v)->v.getSupplier().getRating()).reversed();

        vehicles.sort(byType
            .thenComparing(byRating));

        ArrayList<String> typesAlreadyFound = new ArrayList<>();

        vehicles.forEach(vehicle ->
        {
            Sipp sipp = vehicle.getSipp();
            Supplier supplier = vehicle.getSupplier();

            if(!typesAlreadyFound.contains(sipp.getCarType()))
            {
                typesAlreadyFound.add(sipp.getCarType());

                addResult(new TaskResult(this.getClass().getSimpleName(),
                        vehicle.getName(),
                        vehicle.getSipp().getCarType(),
                        supplier.getName(),
                        String.valueOf(supplier.getRating()))
                );
            }
        });
    }
}
