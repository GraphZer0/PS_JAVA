package CreateCircle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);

        System.out.printf("Начальный радиус: %.2f%n" ,circle.getArea());
        System.out.printf("Площадь круга: %.2f%n", circle.getRadius());

        circle.setRadius(10.0);
        System.out.printf("Радиус равный 10: %.2f%n", circle.getArea());
        System.out.printf("Площадь круга: %.2f%n", circle.getRadius());

        circle.setRadius(-10.0);
        System.out.printf("Радиус равный 10: %.2f%n", circle.getArea());
        System.out.printf("Площадь круга: %.2f%n", circle.getRadius());
    }
}
