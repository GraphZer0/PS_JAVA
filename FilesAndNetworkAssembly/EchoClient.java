package FilesAndNetworkAssembly;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Эхо-клиент запущен. Подключение к серверу " + SERVER_ADDRESS + ":" + SERVER_PORT);

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Подключено к серверу. Введите сообщения (для выхода введите 'bye' или 'exit'):");

            String userInput;
            while (true) {
                System.out.print("> ");
                userInput = scanner.nextLine();

                if (userInput.trim().isEmpty()) {
                    continue;
                }

                // Отправляем сообщение серверу
                out.println(userInput);

                // Получаем ответ от сервера
                String response = in.readLine();

                if (response == null) {
                    System.out.println("Сервер закрыл соединение.");
                    break;
                }

                System.out.println("Ответ от сервера: " + response);

                // Проверка на завершение
                if ("bye".equalsIgnoreCase(userInput) || "exit".equalsIgnoreCase(userInput)) {
                    System.out.println("Завершение работы клиента.");
                    break;
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("Неизвестный хост: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка подключения к серверу: " + e.getMessage());
        }
    }
}