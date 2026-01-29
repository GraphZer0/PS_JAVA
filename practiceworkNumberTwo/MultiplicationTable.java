package practiceworkNumberTwo;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите число от 1 до 9: ");
            int num =  input.nextInt();

            if(num <= 0 && num >= 10) {
                System.out.println("Ошибка, выбери диапазон чисел от 0 до 10");
                return;
            }
            for(int i = 1; i <= 9; i++) {
                System.out.println((num * 1) + " * " + (i) + " = " + (num * i));
            }
        }

    }
}
