package SmartHome;

public class Main {
    public static void main(String[] args) {
        SmartHome home = new SmartHome();

        SmartLight livingRoomLight = new SmartLight("Living Room Light", RoomType.Ballroom, 50);
        SmartThermostat bedroomThermostat = new SmartThermostat("Bedroom Thermostat", RoomType.Bedroom, 22);
        SmartTV kitchenTV = new SmartTV("Kitchen TV", RoomType.Kitchen, 30);
        SmartLight hallwayLight = new SmartLight("Hallway Light", RoomType.hallway, 10);


        home.addDevice(livingRoomLight);
        home.addDevice(bedroomThermostat);
        home.addDevice(kitchenTV);
        home.addDevice(hallwayLight);

        System.out.println("=== Тестируем массовое включение ===");
        home.turnOnAllDevice();

        System.out.println("\n=== Тестируем увеличение значений (только для Controllable) ===");
        home.increaseAllDevice();
        home.increaseAllDevice();

        System.out.println("\n=== Тестируем уменьшение значений ===");
        home.decreaseAllDevice();

        System.out.println("\n=== Тестируем массовое выключение ===");
        home.turnOffAllDevice();

        System.out.println("\n=== Статистика ===");
        home.stats.printStats();

        System.out.println("\n=== Индивидуальные проверки ===");
        System.out.println("Living Room Light brightness: " + ((SmartLight) livingRoomLight).brightness);
        System.out.println("Bedroom Thermostat temperature: " + ((SmartThermostat) bedroomThermostat).temperature);
        System.out.println("Kitchen TV volume: " + ((SmartTV) kitchenTV).volume);
    }
}