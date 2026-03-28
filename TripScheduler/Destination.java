package TripScheduler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Destination implements Serializable{

    private static final long serialVersionUID = 1L;

    private String city;
    private String country;
    private String destination;
    private LocalDate visitDate;

    public Destination() {}

    public Destination(String city, String country, String destination, LocalDate visitDate) {
        this.city = city;
        this.country = country;
        this.destination = destination;
        this.visitDate = visitDate;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", destination='" + destination + '\'' +
                ", visitDate=" + visitDate +
                '}';
    }

    private void  writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Serializing Destination: " + city);
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Deserializing Destination: " + city);
    }
}