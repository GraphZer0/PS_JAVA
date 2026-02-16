package JavaCoreCollection.DetectiveGame.model;

public class Evidence {

    private final String name;

    public Evidence(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Чтобы Set корректно работал и не было дубликатов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evidence)) return false;
        Evidence evidence = (Evidence) o;
        return name.equalsIgnoreCase(evidence.name); // регистр игнорируется
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}