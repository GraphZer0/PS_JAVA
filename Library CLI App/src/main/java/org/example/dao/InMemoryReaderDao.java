package org.example.dao;

import org.example.model.Reader;
import java.util.ArrayList;
import java.util.List;

public class InMemoryReaderDao implements ReaderDao {

    private final List<Reader> readers = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public void save(Reader reader) {
        reader.setId(currentId++);
        readers.add(reader);
    }

    @Override
    public List<Reader> findAll() {
        return readers;
    }

    @Override
    public Reader findById(Long id) {
        return readers.stream()
                .filter(reader -> reader.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}