package org.example;

public class DeliveryCostCalculatorTest {

    private static final double MIN_DELIVERY_COST = 400.0;

    public double calculate(
            double distance,
            String size,
            boolean fragile,
            String workload
    ) {
        double cost = 0;

        if (fragile && distance > 30) {
            throw new IllegalArgumentException(
                    "Хрупкие грузы нельзя перевозить на расстояние более 30 км"
            );
        }

        if (distance > 30) {
            cost += 300;
        } else if (distance > 10) {
            cost += 200;
        } else if (distance > 2) {
            cost += 100;
        } else {
            cost += 50;
        }

        if ("large".equalsIgnoreCase(size)) {
            cost += 200;
        } else if ("small".equalsIgnoreCase(size)) {
            cost += 100;
        } else {
            throw new IllegalArgumentException("Некорректный размер груза");
        }

        if (fragile) {
            cost += 300;
        }

        double coefficient;

        switch (workload.toLowerCase()) {
            case "very_high":
                coefficient = 1.6;
                break;
            case "high":
                coefficient = 1.4;
                break;
            case "elevated":
                coefficient = 1.2;
                break;
            case "normal":
                coefficient = 1.0;
                break;
            default:
                throw new IllegalArgumentException("Некорректный уровень загруженности");
        }

        cost *= coefficient;

        return Math.max(cost, MIN_DELIVERY_COST);
    }
}