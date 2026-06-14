package org.example.dao;

import org.example.model.Loan;
import java.util.ArrayList;
import java.util.List;

public class InMemoryLoanDao implements LoanDao {

    private final List<Loan> loans = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public void save(Loan loan) {
        loan.setId(currentId++);
        loans.add(loan);
    }

    @Override
    public List<Loan> findAll() {
        return loans;
    }

    @Override
    public Loan findActiveByBookId(Long bookId) {
        return loans.stream()
                .filter(loan -> loan.getBookId().equals(bookId))
                .filter(Loan::isActive)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Loan loan) {
    }
}