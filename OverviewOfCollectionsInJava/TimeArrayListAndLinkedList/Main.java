package TimeArrayListAndLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Сравнение производительности ArrayList и LinkedList
 * при доступе к элементам по случайному индексу.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=".repeat(70));
        System.out.println("Сравнение ArrayList и LinkedList");
        System.out.println("Заполнение: 1 000 000 случайных элементов");
        System.out.println("Тест: 1000 обращений по случайному индексу");
        System.out.println("=".repeat(70));

        // Создание и заполнение ArrayList
        System.out.println("\n📦 Создание ArrayList...");
        long startCreate = System.nanoTime();
        ArrayList<Integer> arrayList = ArrayListDemo.createArrayList();
        long arrayListCreateTime = System.nanoTime() - startCreate;
        System.out.println("✓ ArrayList создан за " +
                (arrayListCreateTime / 1_000_000.0) + " мс");

        // Создание и заполнение LinkedList
        System.out.println("\n📦 Создание LinkedList...");
        startCreate = System.nanoTime();
        LinkedList<Integer> linkedList = LinkedListDemo.createLinkedLIst();
        long linkedListCreateTime = System.nanoTime() - startCreate;
        System.out.println("✓ LinkedList создан за " +
                (linkedListCreateTime / 1_000_000.0) + " мс");

        // Тестирование ArrayList
        System.out.println("\n🔍 Тестирование ArrayList (1000 случайных обращений)...");
        long arrayListAccessTime = ArrayListDemo.testRandomIndex(arrayList);
        System.out.println("✓ Время доступа: " +
                (arrayListAccessTime / 1_000_000.0) + " мс");

        // Тестирование LinkedList
        System.out.println("\n🔍 Тестирование LinkedList (1000 случайных обращений)...");
        long linkedListAccessTime = LinkedListDemo.testRandomIndex(linkedList);
        System.out.println("✓ Время доступа: " +
                (linkedListAccessTime / 1_000_000.0) + " мс");

        // Результаты
        printResults(arrayListCreateTime, linkedListCreateTime,
                arrayListAccessTime, linkedListAccessTime);
    }

    private static void printResults(long arrayCreateTime, long linkedCreateTime,
                                     long arrayAccessTime, long linkedAccessTime) {

        System.out.println("\n" + "=".repeat(70));
        System.out.println("📊 РЕЗУЛЬТАТЫ");
        System.out.println("=".repeat(70));

        // Время создания
        System.out.println("\n1. ВРЕМЯ СОЗДАНИЯ И ЗАПОЛНЕНИЯ:");
        System.out.printf("   ArrayList:  %10.2f мс%n", arrayCreateTime / 1_000_000.0);
        System.out.printf("   LinkedList: %10.2f мс%n", linkedCreateTime / 1_000_000.0);

        if (arrayCreateTime < linkedCreateTime) {
            double times = (double) linkedCreateTime / arrayCreateTime;
            System.out.printf("   → ArrayList быстрее в %.2f раза%n", times);
        } else {
            double times = (double) arrayCreateTime / linkedCreateTime;
            System.out.printf("   → LinkedList быстрее в %.2f раза%n", times);
        }

        // Время доступа
        System.out.println("\n2. ВРЕМЯ СЛУЧАЙНОГО ДОСТУПА (1000 обращений):");
        System.out.printf("   ArrayList:  %10.2f мс%n", arrayAccessTime / 1_000_000.0);
        System.out.printf("   LinkedList: %10.2f мс%n", linkedAccessTime / 1_000_000.0);

        if (arrayAccessTime < linkedAccessTime) {
            double times = (double) linkedAccessTime / arrayAccessTime;
            System.out.printf("   → ArrayList быстрее в %.0f раз%n", times);
        } else {
            double times = (double) arrayAccessTime / linkedAccessTime;
            System.out.printf("   → LinkedList быстрее в %.0f раз%n", times);
        }

        // Объяснение
        System.out.println("\n" + "=".repeat(70));
        System.out.println("💡 ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:");
        System.out.println("=".repeat(70));

        System.out.println("\n📌 ArrayList:");
        System.out.println("   • Хранит элементы в массиве");
        System.out.println("   • Доступ по индексу: O(1) — мгновенный");
        System.out.println("   • Просто вычисляет адрес: array[index]");
        System.out.println("   • Идеален для случайного доступа");

        System.out.println("\n📌 LinkedList:");
        System.out.println("   • Хранит элементы в связанных узлах");
        System.out.println("   • Доступ по индексу: O(n) — линейный");
        System.out.println("   • Нужно пройти по цепочке от начала");
        System.out.println("   • Медленный для случайного доступа");

        System.out.println("\n🎯 ВЫВОД:");
        System.out.println("   ArrayList в сотни/тысячи раз быстрее для доступа по индексу!");
        System.out.println("   Используйте LinkedList только для вставок/удалений в начале/конце.");

        System.out.println("\n" + "=".repeat(70));
    }
}
