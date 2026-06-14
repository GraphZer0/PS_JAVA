package org.example.cli;

import org.example.model.Book;
import org.example.model.Reader;
import org.example.service.BookService;
import org.example.service.LoanService;
import org.example.service.ReaderService;

import java.util.Scanner;

public class ConsoleMenu {

    private final BookService bookService;
    private final ReaderService readerService;
    private final LoanService loanService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(BookService bookService,
                       ReaderService readerService,
                       LoanService loanService) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.loanService = loanService;
    }

    public void start() {
        while (true) {
            printMenu();

            System.out.print("Выберите пункт: ");
            String command = scanner.nextLine();

            switch (command) {
                case "1" -> addBook();
                case "2" -> showBooks();
                case "3" -> addReader();
                case "4" -> showReaders();
                case "5" -> issueBook();
                case "6" -> returnBook();
                case "7" -> showLoans();
                case "0" -> {
                    System.out.println("Выход из приложения.");
                    return;
                }
                default -> System.out.println("Неизвестная команда.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== Library CLI App ===");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Показать книги");
        System.out.println("3. Добавить читателя");
        System.out.println("4. Показать читателей");
        System.out.println("5. Выдать книгу");
        System.out.println("6. Вернуть книгу");
        System.out.println("7. Показать выдачи");
        System.out.println("0. Выход");
    }

    private void addBook() {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();

        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        bookService.addBook(title, author);
        System.out.println("Книга добавлена.");
    }

    private void showBooks() {
        for (Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }
    }

    private void addReader() {
        System.out.print("Введите имя читателя: ");
        String name = scanner.nextLine();

        System.out.print("Введите email читателя: ");
        String email = scanner.nextLine();

        readerService.addReader(name, email);
        System.out.println("Читатель добавлен.");
    }

    private void showReaders() {
        for (Reader reader : readerService.getAllReaders()) {
            System.out.println(reader);
        }
    }

    private void issueBook() {
        System.out.print("Введите ID книги: ");
        Long bookId = Long.parseLong(scanner.nextLine());

        System.out.print("Введите ID читателя: ");
        Long readerId = Long.parseLong(scanner.nextLine());

        loanService.issueBook(bookId, readerId);
        System.out.println("Книга выдана.");
    }

    private void returnBook() {
        System.out.print("Введите ID книги: ");
        Long bookId = Long.parseLong(scanner.nextLine());

        loanService.returnBook(bookId);
        System.out.println("Книга возвращена.");
    }

    private void showLoans() {
        loanService.getAllLoans().forEach(System.out::println);
    }
}