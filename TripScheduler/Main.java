package TripScheduler;

import TripScheduler.*;
import TripScheduler.TransportType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== START PROGRAM ===");

        // =========================
        // СОЗДАЁМ DESTINATIONS
        // =========================

        Destination d1 =
                new Destination(
                        "Paris",
                        "France",
                        "Visit Eiffel Tower",
                        LocalDate.of(2025, 5, 10));

        Destination d2 =
                new Destination(
                        "Berlin",
                        "Germany",
                        "Museum tour",
                        LocalDate.of(2025, 5, 15));

        Destination d3 =
                new Destination(
                        "Amsterdam",
                        "Netherlands",
                        "Canal прогулка",
                        LocalDate.of(2025, 5, 18));

        // =========================
        // СОЗДАЁМ TRIPS
        // =========================

        Trip trip1 =
                new Trip(
                        1,
                        "Europe Trip",
                        LocalDate.of(2025, 5, 10),
                        LocalDate.of(2025, 5, 20),
                        TransportType.AIRPLAINE);

        trip1.addDestination(d1);
        trip1.addDestination(d2);

        Trip trip2 =
                new Trip(
                        2,
                        "Weekend Trip",
                        LocalDate.of(2025, 6, 1),
                        LocalDate.of(2025, 6, 3),
                        TransportType.TRAIN);

        trip2.addDestination(d3);

        // =========================
        // СОЗДАЁМ КОЛЛЕКЦИЮ TRIPS
        // =========================

        List<Trip> trips =
                new ArrayList<>();

        trips.add(trip1);
        trips.add(trip2);

        // =========================
        // БИНАРНАЯ СЕРИАЛИЗАЦИЯ
        // =========================

        System.out.println("\n=== BINARY SAVE ===");

        TripStorage.saveTrips(
                trips,
                "trips.dat");

        System.out.println("\n=== BINARY LOAD ===");

        List<Trip> loadedTrips =
                TripStorage.loadTrips(
                        "trips.dat");

        System.out.println(
                "Loaded from binary:");

        System.out.println(
                loadedTrips);

        // =========================
        // JSON СЕРИАЛИЗАЦИЯ
        // =========================

        System.out.println("\n=== JSON SAVE ===");

        TripJsonStorage.saveTripsToJson(
                trips,
                "trips.json");

        System.out.println("\n=== JSON LOAD ===");

        List<Trip> jsonTrips =
                TripJsonStorage.loadTripsFromJson(
                        "trips.json");

        System.out.println(
                "Loaded from JSON:");

        System.out.println(
                jsonTrips);

        // =========================
        // В JSON-СТРОКУ
        // =========================

        System.out.println("\n=== JSON STRING ===");

        String jsonString =
                TripJsonStorage.tripsToJsonString(
                        trips);

        System.out.println(
                jsonString);

        // =========================
        // ИЗ JSON-СТРОКИ
        // =========================

        System.out.println("\n=== FROM JSON STRING ===");

        List<Trip> fromString =
                TripJsonStorage.jsonStringToTrips(
                        jsonString);

        System.out.println(
                fromString);

        System.out.println("\n=== END PROGRAM ===");
    }
}