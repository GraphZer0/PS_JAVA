package BasicWork3.Username;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String username = scanner.nextLine();

        // 1. Проверка длины
        if (username.length() < 3 || username.length() > 20) {
            System.out.println("Ошибка: имя пользователя должно содержать от 3 до 20 символов");
            return;
        }

        // 2. Проверка, что начинается с буквы
        Pattern startPattern = Pattern.compile("^[a-zA-Z]");
        Matcher startMatcher = startPattern.matcher(username);
        if (!startMatcher.lookingAt()) {
            System.out.println("Ошибка: имя пользователя должно начинаться с буквы");
            return;
        }

        // 3. Проверка, что содержит только буквы, цифры и _
        Pattern validCharsPattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher charsMatcher = validCharsPattern.matcher(username);
        if (!charsMatcher.matches()) {
            System.out.println("Ошибка: имя пользователя может содержать только буквы, цифры и знак подчеркивания");
            return;
        }

        // 4. Форматирование: нижний регистр + сжатие множественных _
        String formatted = username.toLowerCase();
        formatted = formatted.replaceAll("_+", "_");

        System.out.println(formatted);
    }
}