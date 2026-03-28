package FilesAndNetworkAssembly;

import java.io.*;
import java.net.*;

public class EchoServer {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Эхо-сервер запущен. Ожидание подключений на порту " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Клиент подключился: " + clientSocket.getInetAddress());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Получено от клиента: " + inputLine);

                        // Отправляем сообщение обратно (эхо)
                        out.println(inputLine);

                        // Если клиент отправил "bye" или "exit" — завершаем соединение с этим клиентом
                        if ("bye".equalsIgnoreCase(inputLine) || "exit".equalsIgnoreCase(inputLine)) {
                            System.out.println("Клиент завершил соединение.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при обработке клиента: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Не удалось запустить сервер: " + e.getMessage());
        }
    }
}