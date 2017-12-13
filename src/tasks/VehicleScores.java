package tasks;

import objects.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VehicleScores extends baseTask
{
    @Override
    public void start()
    {
        HashMap<Vehicle, Double> vehicleScores = new HashMap<>();
        HashMap<Vehicle, Double> summedScores = new HashMap<>();

        vehicles.forEach(vehicle -> calcVehicleScore(vehicle, vehicleScores, summedScores));
        ArrayList<Map.Entry<Vehicle, Double>> sortedList = new ArrayList<>(summedScores.entrySet());

        sortedList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        sortedList.forEach(vehicleDoubleEntry ->
        {
            Vehicle vehicle = vehicleDoubleEntry.getKey();

            addResult(new TaskResult(this.getClass().getSimpleName(),
                    vehicle.getName(),
                    String.valueOf(vehicleScores.get(vehicle)),
                    String.valueOf(vehicle.getSupplier().getRating()),
                    String.valueOf(summedScores.get(vehicle)))
            );
        });
    }

    private void calcVehicleScore(Vehicle vehicle, HashMap<Vehicle, Double> vehicleScores, HashMap<Vehicle, Double> summedScores)
    {
        double score = vehicle.getSipp().isManualTransmission() ? 1 : 5;

        if(vehicle.getSipp().isAirConditioned()) { score += 2; }

        vehicleScores.put(vehicle, score);
        summedScores.put(vehicle, vehicle.getSupplier().getRating() + score);
    }
}
