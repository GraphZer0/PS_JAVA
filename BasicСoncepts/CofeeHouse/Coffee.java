package BasicСoncepts.CofeeHouse;

public class Coffee extends MenuItem implements Preparable{
    private int cofeeStrenthg; // крепость кофе от 1 до 10

    public Coffee(String name, double price, int cofeeStrenthg) {
        super(name, price);
        this.cofeeStrenthg = cofeeStrenthg;

    }
    public int getCofeeStrenthg() {
        return cofeeStrenthg;
    }

    @Override
    public void prepare() {
        System.out.println("Завариваем кофейынй напиток " + name + " крепостью " + cofeeStrenthg);
    }
}
