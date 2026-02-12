package CreateCircle;

public class TestCircle {

    public static void main(String[] args) {
        System.out.println("Запуск тестов класса Circle\n");

        testConstructorValid();
        testConstructorInvalid();
        testSetRadiusValid();
        testSetRadiusInvalid();
        testGetArea();

        System.out.println("\nВсе тесты завершены.");
    }

    // tested: конструктор с допустимым радиусом
    private static void testConstructorValid() {
        System.out.println("Тест 1: Конструктор с допустимым радиусом");
        try {
            Circle circle = new Circle(5.0);
            if (circle.getRadius() == 5.0) {
                System.out.println("    Пройден: радиус правильно инициализирован");
            } else {
                System.out.println("    Провален: радиус не совпадает");
            }
        } catch (Exception e) {
            System.out.println("    Провален: неожиданно выброшено исключение");
        }
    }

    // Тест: конструктор с недопустимым радиусом
    private static void testConstructorInvalid() {
        System.out.println("Тест 2: Конструктор с недопустимым радиусом");
        boolean exceptionThrown = false;
        try {
            new Circle(0);
        } catch (IllegalArgumentException e) {
            if ("Радиус должен быть больше нуля".equals(e.getMessage())) {
                exceptionThrown = true;
            }
        } catch (Exception e) {
            // Неправильный тип исключения
        }

        try {
            new Circle(-3.0);
        } catch (IllegalArgumentException e) {
            if ("Радиус должен быть больше нуля".equals(e.getMessage())) {
                exceptionThrown = true;
            }
        }

        if (exceptionThrown) {
            System.out.println("    Пройден: корректно выброшено исключение");
        } else {
            System.out.println("    Провален: исключение не выброшено или сообщение неверное");
        }
    }

    // Тест: setRadius с допустимым значением
    private static void testSetRadiusValid() {
        System.out.println("Тест 3: setRadius с допустимым значением");
        try {
            Circle circle = new Circle(5.0);
            circle.setRadius(10.0);
            if (circle.getRadius() == 10.0) {
                System.out.println("    Пройден: радиус успешно изменён");
            } else {
                System.out.println("    Провален: радиус не изменился");
            }
        } catch (Exception e) {
            System.out.println("    Провален: неожиданно выброшено исключение");
        }
    }

    // Тест: setRadius с недопустимым значением
    private static void testSetRadiusInvalid() {
        System.out.println("Тест 4: setRadius с недопустимым значением");
        boolean exceptionThrown = false;
        try {
            Circle circle = new Circle(5.0);
            circle.setRadius(0);
        } catch (IllegalArgumentException e) {
            if ("Радиус должен быть больше нуля".equals(e.getMessage())) {
                exceptionThrown = true;
            }
        }

        try {
            Circle circle = new Circle(5.0);
            circle.setRadius(-2.5);
        } catch (IllegalArgumentException e) {
            if ("Радиус должен быть больше нуля".equals(e.getMessage())) {
                exceptionThrown = true;
            }
        }

        if (exceptionThrown) {
            System.out.println("    Пройден: корректно выброшено исключение");
        } else {
            System.out.println("    Провален: исключение не выброшено или сообщение неверное");
        }
    }

    // Тест: getArea возвращает правильную площадь
    private static void testGetArea() {
        System.out.println("Тест 5: Метод getArea");
        try {
            Circle circle = new Circle(1.0);
            double expected = Math.PI * 1.0 * 1.0;
            double actual = circle.getArea();
            double delta = 1e-10; // погрешность для double
            if (Math.abs(expected - actual) < delta) {
                System.out.printf("    Пройден: площадь для r=1.0 = %.10f (ожидаемая %.10f)%n", actual, expected);
            } else {
                System.out.printf("    Провален: площадь неверная (получено %.10f, ожидалось %.10f)%n", actual, expected);
            }

            circle.setRadius(5.0);
            expected = Math.PI * 25.0;
            actual = circle.getArea();
            if (Math.abs(expected - actual) < delta) {
                System.out.printf("    Пройден: площадь для r=5.0 = %.2f%n", actual);
            } else {
                System.out.printf("    Провален: площадь для r=5.0 неверная%n");
            }
        } catch (Exception e) {
            System.out.println("    Провален: ошибка при вычислении площади");
        }
    }
}