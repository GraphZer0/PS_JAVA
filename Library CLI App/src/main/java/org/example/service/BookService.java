package org.example.service;

import org.example.dao.BookDao;
import org.example.model.Book;
import java.util.List;

public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookDao.save(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }
}