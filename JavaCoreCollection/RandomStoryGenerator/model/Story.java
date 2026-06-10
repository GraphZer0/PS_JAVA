package JavaCoreCollection.RandomStoryGenerator.model;

public class Story {

    private final String text;

    public Story(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}