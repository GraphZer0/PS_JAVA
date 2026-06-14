package org.example.service;

import org.example.dao.ReaderDao;
import org.example.model.Reader;
import java.util.List;

public class ReaderService {

    private final ReaderDao readerDao;

    public ReaderService(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }

    public void addReader(String name, String email) {
        Reader reader = new Reader(name, email);
        readerDao.save(reader);
    }

    public List<Reader> getAllReaders() {
        return readerDao.findAll();
    }
}