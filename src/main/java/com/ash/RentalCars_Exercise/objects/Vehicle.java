package com.ash.RentalCars_Exercise.objects;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class Vehicle
{
    private final UUID uuid;
    private String name;
    private Double price;

    private Sipp sipp;
    private Supplier supplier;

    public Vehicle(String name, Double price)
    {
        uuid = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public UUID getUuid() { return uuid; }

    public String getName() { return name; }

    public Sipp getSipp() { return sipp; }
    @Autowired
    public void setSipp(Sipp sipp) { this.sipp = sipp; }

    public Double getPrice() { return price; }

    public Supplier getSupplier() { return supplier; }
    @Autowired
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
