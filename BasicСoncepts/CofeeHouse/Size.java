package BasicСoncepts.CofeeHouse;

public enum Size {
    SMALL("Маленький", 0.8),
    MEDIUM("Средний", 1.0),
    LARGE("Большой", 1.5);

    private final String description;
    private final double priceMultiplier; // коэффициент для расчёта цены относительно базовой

    Size(String description, double priceMultiplier) {
        this.description = description;
        this.priceMultiplier = priceMultiplier;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    @Override
    public String toString() {
        return description;
    }
}