package BasicСoncepts.CofeeHouse;

public class Pastry extends MenuItem implements Preparable {
    private String typeOfPastry; //без или с сахаром(глюкозой)

    public Pastry(String name, double price, String typeOfPastry) {
        super(name, price);
        this.typeOfPastry = typeOfPastry;
    }

    public String getTypeOfPastry() {
        return typeOfPastry;
    }

    public void prepare() {
        System.out.println("К кофейному напитку подаем: " + name + " изготовленный по рецепту " + typeOfPastry);
    }
}
