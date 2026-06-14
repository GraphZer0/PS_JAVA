package org.example;

import org.example.cli.ConsoleMenu;
import org.example.dao.BookDao;
import org.example.dao.InMemoryBookDao;
import org.example.dao.InMemoryLoanDao;
import org.example.dao.InMemoryReaderDao;
import org.example.dao.LoanDao;
import org.example.dao.ReaderDao;
import org.example.service.BookService;
import org.example.service.LoanService;
import org.example.service.ReaderService;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new InMemoryBookDao();
        ReaderDao readerDao = new InMemoryReaderDao();
        LoanDao loanDao = new InMemoryLoanDao();

        BookService bookService = new BookService(bookDao);
        ReaderService readerService = new ReaderService(readerDao);
        LoanService loanService = new LoanService(bookDao, readerDao, loanDao);

        ConsoleMenu menu = new ConsoleMenu(bookService, readerService, loanService);
        menu.start();
    }
}