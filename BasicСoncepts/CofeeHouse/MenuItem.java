package BasicСoncepts.CofeeHouse;

public abstract class MenuItem {
    protected double price;
    protected String name;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
