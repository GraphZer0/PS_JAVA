package PracticalWorkNo3JavaCoreFilesandNetwork.SynchronizationOfStreamsinACafe;

public class Visitor extends Thread {

    private final String visitorName;

    public Visitor(String visitorName) {
        this.visitorName = visitorName;
    }

    @Override
    public void run() {

        //Кол-во попыток получить блюдо
        int attempts = 5;

        while (attempts > 0) {

            String dish = null;

            synchronized (CafeSimulation.orders) {
                //пока никто не пришел - список пуст
                while (CafeSimulation.orders.isEmpty() && !CafeSimulation.cafeClosed) {

                    System.out.println(visitorName + ": ждет заказ...");


                    try {
                        CafeSimulation.orders.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (CafeSimulation.orders.isEmpty() && CafeSimulation.cafeClosed) {
                    System.out.println(visitorName + " ушел: кафе закрыто.");

                    break;
                }
                dish = CafeSimulation.orders.remove(0);
                System.out.println(visitorName + " получил: " + dish);

                attempts--;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(visitorName + " съел " + dish);
        }
        System.out.println(visitorName + " завершил посещение кафе");
    }
}
