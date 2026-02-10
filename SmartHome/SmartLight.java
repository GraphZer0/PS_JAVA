package SmartHome;

public class SmartLight extends SmartDevice implements Controllable{
    int brightness;

    public SmartLight(String name, RoomType room, int brightness) {
        super(name, room);
        this.brightness = brightness;
    }

    @Override
    public void increaseValue() {
        brightness++;
    }

    @Override
    public void decreaseValue() {
        brightness--;
    }
}
