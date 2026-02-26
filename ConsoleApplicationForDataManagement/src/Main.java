import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

        while(true){
            /* вывод списков варинатов
            считываем номер действия и дополнительные данные
            выполняем действия
             */
            printMessage();
            Command command = readCommand(); //здесь должна получится некая команда
            if(command.getAction() == Action.EXIT) {
                return;
            }
            else if (command.getAction() == Action.ERROR) {
                continue;
            } else {
                STUDENT_COMMAND_HANDLER.processCommand(command);
            }
        }
    }
    private  static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine(); //первым считываем код, которым является номер варианта
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);

            if(action.isReqiredAditionalData()) {
                String data = scanner.nextLine();
                return new Command(action, data);
                //Выполняем команду
            }
            else {
                return new Command(action);
            }
        } catch (Exception ex ) {
            System.out.println("Проблема обработки ввода: " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void printMessage() {
        System.out.println("========================================="); // --> меню создаем в Action (enum)
        System.out.println("0. Выход");
        System.out.println("1. Создание данных");
        System.out.println("2. Обновления данных");
        System.out.println("3. Удаление данных");
        System.out.println("4. Вывод статистики по курсам");
        System.out.println("5. Поиск по фамилии");
        System.out.println("=========================================");
    }
}