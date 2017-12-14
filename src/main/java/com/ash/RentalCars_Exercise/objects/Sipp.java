package com.ash.RentalCars_Exercise.objects;

import java.util.HashMap;

public class Sipp
{
    private String sippStr;

    private String carType;
    private String doors;
    private String transmission;
    private String fuel;
    private String airCon;

    public Sipp(String sippStr, HashMap<Integer, String> definitions)
    {
        try
        {
            this.sippStr = sippStr;
            this.carType = definitions.get(1);
            this.doors = definitions.get(2);
            this.transmission = definitions.get(3);

            String[] fuelAirCon = definitions.get(4).split("/");
            this.fuel = fuelAirCon[0];
            this.airCon = fuelAirCon[1];

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public String getSippStr() { return sippStr; }
    public String getCarType() { return carType; }
    public String getDoors() { return doors; }
    public String getTransmission() { return transmission; }
    public String getFuel() { return fuel; }
    public String getAirCon() { return airCon; }

    public boolean isAirConditioned() { return airCon.equals("AC"); }
    public boolean isManualTransmission() { return transmission.equals("Manual"); }
}
