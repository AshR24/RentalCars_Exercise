package com.ash.RentalCars_Exercise.objects;

public class Supplier
{
    private String name;
    private double rating;

    public Supplier(String name, double rating)
    {
        this.name = name;
        this.rating = rating;
    }

    public String getName() { return name; }

    public double getRating() { return rating; }
}
