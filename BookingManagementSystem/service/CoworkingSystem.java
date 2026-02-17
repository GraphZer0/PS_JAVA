package JavaCoreCollectionSecond.BookingManagementSystem.service;

import JavaCoreCollectionSecond.BookingManagementSystem.exceptions.*;
import JavaCoreCollectionSecond.BookingManagementSystem.model.User;
import JavaCoreCollectionSecond.BookingManagementSystem.model.Workspace;

import java.util.TreeMap;
import java.util.TreeSet;

public class CoworkingSystem {

    private TreeSet<Workspace> workspaces = new TreeSet<>();
    private TreeMap<User, TreeSet<Workspace>> bookings = new TreeMap<>();

    public void addWorkspace(Workspace workspace) {
        workspaces.add(workspace);
    }

    public void registerUser(User user) {
        bookings.put(user, new TreeSet<>());
    }

    public void bookWorkspace(User user, Workspace workspace)
            throws WorkspaceNotAvailableException, UserNotRegisteredException {

        if (!bookings.containsKey(user)) {
            throw new UserNotRegisteredException("Пользователь не зарегистрирован");
        }

        if (!workspace.isAvailable()) {
            throw new WorkspaceNotAvailableException("Рабочее место уже занято");
        }

        workspace.markAsBooked();
        user.bookWorkspace(workspace);
        bookings.get(user).add(workspace);
    }

    public void cancelWorkspace(User user, Workspace workspace)
            throws UserNotRegisteredException {

        if (!bookings.containsKey(user)) {
            throw new UserNotRegisteredException("Пользователь не зарегистрирован");
        }

        workspace.markAsAvailable();
        user.cancelWorkspace(workspace);
        bookings.get(user).remove(workspace);
    }

    public void printAllBookings() {
        for (User user : bookings.keySet()) {
            System.out.println(user);
            System.out.println("Его бронирования: " + bookings.get(user));
        }
    }
}