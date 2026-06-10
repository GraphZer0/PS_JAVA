package JavaCoreCollectionSecond.BookingManagementSystem.model;

import java.util.TreeSet;
import java.util.UUID;

public class User implements Comparable<User> {
    private String name;
    private String surname;
    private UUID id;
    private TreeSet<Workspace> bookedWorkspaces;

    public User(String name, String surname, UUID uuid, TreeSet<Workspace> bookedWorkspaces) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID(); //здесь для каждого user будет каждый уникальынй UUID
        this.bookedWorkspaces = new TreeSet<>(); //пустой отсортирвоанный список рабочих мест
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public TreeSet<Workspace> getBookedWorkspaces() {
        return bookedWorkspaces; //это геттер для TreeSet
    }

    public void bookWorkspace(Workspace workspace) {
        bookedWorkspaces.add(workspace); //добавить место/бронь
    }
    public void cancelWorkspace(Workspace workspace) {
        bookedWorkspaces.remove(workspace); //удалить место/бронь
    }

    public int compareTo(User other) {
        int surnameCompare = this.surname.compareTo(other.surname);
        if (surnameCompare != 0) {
            return surnameCompare;
        }
        return this.name.compareTo(other.name);
    }

    public String toString()
    {
        return surname + " " + name;
    }
}
