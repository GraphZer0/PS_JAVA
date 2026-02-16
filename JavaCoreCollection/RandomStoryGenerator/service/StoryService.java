package JavaCoreCollection.RandomStoryGenerator.service;

import JavaCoreCollection.RandomStoryGenerator.model.Story;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoryService {

    private final List<String> characters = new ArrayList<>();
    private final List<String> actions = new ArrayList<>();
    private final List<String> places = new ArrayList<>();
    private final List<Story> stories = new ArrayList<>();
    private final Random random = new Random();

    public StoryService() {
        initCharacters();
        initActions();
        initPlaces();
    }

    private void initCharacters() {
        characters.add("Гном");
        characters.add("Принцесса");
        characters.add("Робот");
    }

    private void initActions() {
        actions.add("танцует");
        actions.add("летает");
        actions.add("сражается");
    }

    private void initPlaces() {
        places.add("в лесу");
        places.add("на кухне");
        places.add("в космосе");
    }

    // Добавление
    public void addCharacter(String character) {
        if (character != null && !character.trim().isEmpty()) characters.add(character.trim());
    }

    public void addAction(String action) {
        if (action != null && !action.trim().isEmpty()) actions.add(action.trim());
    }

    public void addPlace(String place) {
        if (place != null && !place.trim().isEmpty()) places.add(place.trim());
    }

    // Количество элементов
    public int getCharactersCount() { return characters.size(); }
    public int getActionsCount() { return actions.size(); }
    public int getPlacesCount() { return places.size(); }

    // Генерация истории
    public Story generateStory() {
        if (characters.isEmpty() || actions.isEmpty() || places.isEmpty()) {
            return new Story("Невозможно сгенерировать историю: один из списков пуст.");
        }

        String text = getRandomElement(characters) + " " +
                getRandomElement(actions) + " " +
                getRandomElement(places);

        Story story = new Story(text);
        stories.add(story);
        return story;
    }

    // Получение всех историй
    public List<Story> getAllStories() {
        return new ArrayList<>(stories);
    }

    // Вспомогательный метод
    private String getRandomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }
}