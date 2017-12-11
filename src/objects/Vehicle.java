package objects;

public class Vehicle
{
    private String name;
    private String sipp;
    private double price;

    private Supplier supplier;

    public Vehicle(String name, String sipp, double price)
    {
        this.name = name;
        this.sipp = sipp;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSipp() { return sipp; }
    public void setSipp(String sipp) { this.sipp = sipp; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }

    @Override
    public String toString()
    {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", sipp='" + sipp + '\'' +
                ", price=" + price +
                '}';
    }
}
