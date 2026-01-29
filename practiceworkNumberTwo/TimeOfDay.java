package practiceworkNumberTwo;

import java.util.Scanner;

public class TimeOfDay {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите час (0-23): ");
            int hour = input.nextInt();


            if(hour < 0 || hour > 23){
                System.out.println("Ошибка: час должен быть от 0 до 23!");
            return;}

            String period;
            if(hour >= 6 && hour <= 11){
                period = "Утро";
            } else if(hour >= 12 && hour <= 17){
                period = "День";
            } else if(hour >= 18 && hour <= 21){
                period = "Вечер";
            } else {
                period = "Ночь";
            }

            System.out.println("Сейчас " + period + ".");
        }
    }
}
