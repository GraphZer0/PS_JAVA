package JavaCoreCollectionSecond.TheRankingSystem.model;

import java.util.Objects;

public class Player {

    private int id;
    private String name;
    private int rating;

    public Player(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Player{id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating + '}';
    }
}