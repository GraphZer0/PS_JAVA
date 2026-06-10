package PracticalWorkNo3JavaCoreFilesandNetwork.SynchronizationOfStreamsinACafe;

import java.util.ArrayList;
import java.util.List;

public class CafeSimulation {
    public static final List<String> orders = new ArrayList<>();

    public static boolean cafeClosed = false;

    public static void main(String[] args) {
        System.out.println("Starting Cafe Simulation");

        Chef chef = new Chef();

        Visitor visitor1 = new Visitor("Посетитель 1");
        Visitor visitor2 = new Visitor("Посетитель 2");
        Visitor visitor3 = new Visitor("Посетитель 3");
        chef.start();

        visitor1.start();
        visitor2.start();
        visitor3.start();
    }

}
