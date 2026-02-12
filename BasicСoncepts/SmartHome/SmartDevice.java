package BasicСoncepts.SmartHome;

public abstract class SmartDevice {
    protected final String name;
    protected boolean isOn;
    protected RoomType room;

    public SmartDevice(String name, RoomType room) {
        this.name = name;
        this.isOn = false;
        this.room = room;
    }

    public final void turnOn() {
        isOn = true;
        System.out.println("Device " + name + " turned on");
    }
    public final void turnOff() {
        isOn = false;
        System.out.println("Device " + name + " turned off");
    }

    public final boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }

    public RoomType getRoom() {
        return room;
    }
}
