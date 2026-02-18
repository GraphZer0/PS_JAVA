package JavaCoreCollectionSecond.BookingManagementSystem.model;

public class Workspace implements Comparable<Workspace> {
    private int number; //номер
    private String type; //тип
    private boolean isAvailable;//доступно или нет

    public Workspace(int number, String type, boolean isAvailable) {
        this.number = number;//конструктор типов
        this.type = type;
        this.isAvailable = true; // доступность рабочего места
    }
    public int getNumber() {
        return number; // гетеры на неизменяемость из вне переменной
    }

    public boolean isAvailable() {
        return isAvailable; // гетеры на неизменяемость из вне переменной
    }

    public void markAsBooked() {
        isAvailable = false;//помечает рабочее место как занятое
    }
    public void markAsAvailable() {
        isAvailable = true;//помечает рабочее место как доступное.
    }

    @Override
    public int compareTo(Workspace other) {
        return Integer.compare(this.number, other.number);
    }
    @Override
    public String toString() {
        return "Workspace #" + number +
                " | Type: " + type +
                " | Available: " + isAvailable;
    }
}


