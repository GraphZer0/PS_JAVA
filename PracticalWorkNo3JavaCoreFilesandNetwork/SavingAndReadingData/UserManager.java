package PracticalWorkNo3JavaCoreFilesandNetwork.SavingAndReadingData;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users = new ArrayList<>();
    private final Path filePath = Paths.get("users.txt");

    // загрузка из файла
    public void loadFromFile() {
        users.clear();

        if (!Files.exists(filePath)) {
            return;
        }

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    String name = parts[0];
                    String city = parts[1];

                    users.add(new User(name, city));
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // сохранение одного пользователя (append)
    public void saveToFile(User user) {
        String line = user.getName() + "," + user.getCity() + System.lineSeparator();

        try {
            Files.write(
                    filePath,
                    line.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    // добавление пользователя
    public void addUser(User user) {
        users.add(user);
        saveToFile(user);
    }

    public List<User> getUsers() {
        return users;
    }
}