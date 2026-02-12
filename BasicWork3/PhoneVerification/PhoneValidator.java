package BasicWork3.PhoneVerification;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона в международном формате:");
        String phone = scanner.nextLine().trim();
        String regex = "^\\+(\\d{1,3})[ -]?(\\d{1,3})[ -]?(\\d+(?:-\\d+)*)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            String mainPart = matcher.group(3); // основная часть номера (может содержать дефисы)
            int mainDigitsCount = mainPart.replaceAll("-", "").length();

            if (mainDigitsCount >= 5 && mainDigitsCount <= 8) {
                System.out.println("Валидный номер телефона");
            } else {
                System.out.println("Невалидный номер телефона");
            }
        } else {
            System.out.println("Невалидный номер телефона");
        }
    }
}