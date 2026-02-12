package BasicСoncepts.CofeeHouse;

public class Tea extends MenuItem implements Preparable{
    private String kindOfTea;

    public Tea(String name, double price, String kindOfTea) {
        super(name, price);
        this.kindOfTea = kindOfTea;
    }

    public String getKindOfTea() {
        return kindOfTea;
    }

    @Override
    public void prepare() {
        System.out.println("Запить все это можно: " + name + " зеленым чаем");
    }
}
