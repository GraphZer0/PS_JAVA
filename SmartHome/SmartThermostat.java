package SmartHome;

public class SmartThermostat extends SmartDevice implements Controllable {
    int temperature;

    public SmartThermostat(String name, RoomType room, int temperature) {
        super(name, room);
        this.temperature = temperature;
    }

    @Override
    public void increaseValue() {
        this.temperature++;
    }
    @Override
    public void decreaseValue() {
        this.temperature--;
    }
}