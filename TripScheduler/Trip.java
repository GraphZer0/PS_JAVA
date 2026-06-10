package TripScheduler;

import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private LocalDate startTime;
    private LocalDate endTime;
    private TransportType trasportType;

    private List<Destination> destinations;

    public Trip() {
        this.destinations = new ArrayList<>();
    }
    public Trip(int id, String title, LocalDate startTime, LocalDate endTime, TransportType trasportType) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trasportType = trasportType;

        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public TransportType getTrasportType() {
        return trasportType;
    }

    @Override
    public String toString() {
        return "Trip{" +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", trasportType=" + trasportType +
                ", destinations=" + destinations +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Serializing Trip: " + title);
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Deserializing Trip: " + title);
        in.defaultReadObject();
    }
}
