package BasicСoncepts.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<SmartDevice> devices;
    HomeStats stats;

    public SmartHome() {
        devices = new ArrayList<>();
        stats = new HomeStats();
    }
    public void addDevice(SmartDevice device) {
        devices.add(device);
        stats.deviceCount++;
    }
    public void removeDevice(SmartDevice device) {
        devices.remove(device);
        stats.deviceCount--;
    }

    public void turnOnAllDevice(){
        for(SmartDevice device : devices){
            device.turnOn();
            stats.turnOnnDevice++;

        }
    }
    public void turnOffAllDevice(){
        for(SmartDevice device : devices){
            device.turnOff();
            stats.turnOffnDevice++;
        }
    }

    public void increaseAllDevice(){
        for(SmartDevice device : devices){
            if (device instanceof Controllable) {
                ((Controllable) device).increaseValue();
            }
        }
    }
    public void decreaseAllDevice(){
        for(SmartDevice device : devices){
            if (device instanceof Controllable) {
                ((Controllable) device).decreaseValue();
            }
        }
    }

    public static class HomeStats {
        private int deviceCount;
        private int turnOnnDevice;
        private int turnOffnDevice;

        public void printStats() {
            System.out.println("Статистика умного дома:");
            System.out.println("Количество устройств: " + deviceCount);
            System.out.println("Включений: " + turnOnnDevice);
            System.out.println("Выключений: " + turnOffnDevice);
        }
    }
}
