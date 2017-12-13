package objects;

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
    public void setSipp(Sipp sipp) { this.sipp = sipp; }

    public Double getPrice() { return price; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
