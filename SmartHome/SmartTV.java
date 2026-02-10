package SmartHome;

public class SmartTV extends SmartDevice implements Controllable{
    int volume;

    public SmartTV(String name, RoomType room, int volume) {
        super(name, room);
        this.volume = volume;
    }

    @Override
    public void increaseValue() {
        this.volume++;
    }
    @Override
    public void decreaseValue() {
        this.volume--;
    }
}
