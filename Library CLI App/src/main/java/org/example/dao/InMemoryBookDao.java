package org.example.dao;

import org.example.model.Book;
import java.util.ArrayList;
import java.util.List;

public class InMemoryBookDao implements BookDao {

    private final List<Book> books = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public void save(Book book) {
        book.setId(currentId++);
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Book book) {
    }
}