package TripScheduler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private List<Trip> trips;

    public User(){
        this.trips = new ArrayList<>();
    }

    public User(int id, String name, String email, List<Trip> trips) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.trips = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", trips=" + trips +
                ", email='" + email + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Serializing Name: " + name);
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Deserializing Name: " + name);
        in.defaultReadObject();
    }
}
