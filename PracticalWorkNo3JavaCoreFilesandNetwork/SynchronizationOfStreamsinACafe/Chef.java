package PracticalWorkNo3JavaCoreFilesandNetwork.SynchronizationOfStreamsinACafe;

import java.util.Random;

public class Chef extends Thread {

    private final String[] dishes = {
            "Бурегр",
            "Суп",
            "Пицца",
            "Паста",
            "Салат"
    };
    private final Random random = new Random();

    @Override
    public void run() {

        int orderNum = 1;

        while (orderNum <= 10) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CafeSimulation.orders) {

                    String dish = dishes[random.nextInt(dishes.length)];

                    synchronized (CafeSimulation.orders) {

                    CafeSimulation.orders.add(dish);

                    System.out.println("Повар приготовил " + dish);
                    orderNum++;

                    CafeSimulation.orders.notifyAll();
                }
            }
        }
        synchronized (CafeSimulation.orders) {
            CafeSimulation.cafeClosed = true;
            System.out.println("Повар закончил работу. Кафе закрывается.");
            CafeSimulation.orders.notifyAll();
        }
    }
}
