package TripScheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//import TripScheduler.projectlib.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TripJsonStorage{

    // Создаём ObjectMapper

    private static ObjectMapper mapper =
            new ObjectMapper();
    static {
        // Красивый формат JSON
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // Поддержка LocalDate
        mapper.findAndRegisterModules();
    }

    // =========================
    // СОХРАНЕНИЕ В JSON ФАЙЛ
    // =========================

    public static void saveTripsToJson(
            List<Trip> trips,
            String fileName) {

        try {
            mapper.writeValue(new File(fileName), trips);
            System.out.println("Trips saved to JSON: " + fileName);

        } catch (IOException e) {System.out.println("Error saving JSON");
            e.printStackTrace();
        }
    }

    // =========================
    // ЗАГРУЗКА ИЗ JSON ФАЙЛА
    // =========================

    public static List<Trip> loadTripsFromJson(
            String fileName) {

        try {Trip[] tripsArray = mapper.readValue(new File(fileName), Trip[].class);
            return Arrays.asList(tripsArray);
        } catch (IOException e) {
            System.out.println("Error loading JSON");
            e.printStackTrace();
        }
        return null;
    }
    // =========================
    // ПРЕОБРАЗОВАНИЕ В СТРОКУ
    // =========================

    public static String tripsToJsonString(
            List<Trip> trips) {
        try {
            return mapper.writeValueAsString(trips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // =========================
    // ВОССТАНОВЛЕНИЕ ИЗ СТРОКИ
    // =========================
    public static List<Trip> jsonStringToTrips(
            String json) {
        try {
            Trip[] tripsArray = mapper.readValue(json, Trip[].class);
            return Arrays.asList(tripsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}