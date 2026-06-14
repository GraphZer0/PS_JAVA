package org.example.dao;

import org.example.model.Book;
import java.util.List;

public interface BookDao {
    void save(Book book);
    List<Book> findAll();
    Book findById(Long id);
    void update(Book book);
}