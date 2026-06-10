package TripScheduler;

import java.io.*;
import java.sql.SQLOutput;
import java.util.List;

import static java.lang.System.out;

public class TripStorage {
    public static void saveTrips(List<Trip> trips, String fileName) {

        //метод сохранения поездок
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(trips);
            System.out.println("Trips saved successfully to file: " + fileName);
        } catch (IOException e) {System.out.println("Error saving trips!");
            e.printStackTrace();
        }
    }

    //метод загрузки поездок
    public static List<Trip> loadTrips(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Trip> trips = (List<Trip>) in.readObject();
            System.out.println("Trips loaded successfully to file: " + fileName);
            return trips;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading trips!");
            e.printStackTrace();
        }

        return null;
    }

}
