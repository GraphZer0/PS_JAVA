package org.example.dao;

import org.example.model.Loan;
import java.util.List;

public interface LoanDao {
    void save(Loan loan);
    List<Loan> findAll();
    Loan findActiveByBookId(Long bookId);
    void update(Loan loan);
}