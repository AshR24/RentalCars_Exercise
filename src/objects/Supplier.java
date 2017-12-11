package objects;

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
    public void setName(String name) { this.name = name; }

    public double getRating() { return rating; }
    public void setRating(long rating) { this.rating = rating; }

    @Override
    public String toString()
    {
        return "objects.Supplier{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        final Supplier other = (Supplier)obj;

        System.out.println("Does " + this.name + " equal " + other.name);

        return this.name.equals(other.name);
    }
}
