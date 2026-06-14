package org.example.model;

import java.time.LocalDate;

public class Loan {
    private Long id;
    private Long bookId;
    private Long readerId;
    private LocalDate loanDate;
    private boolean active;

    public Loan(Long bookId, Long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.loanDate = LocalDate.now();
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public boolean isActive() {
        return active;
    }

    public void close() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "Loan{id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", loanDate=" + loanDate +
                ", active=" + active +
                '}';
    }
}