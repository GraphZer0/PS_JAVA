package org.example.dao;

import org.example.model.Reader;
import java.util.List;

public interface ReaderDao {
    void save(Reader reader);
    List<Reader> findAll();
    Reader findById(Long id);
}