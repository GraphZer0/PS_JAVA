package org.example.service;

import org.example.dao.BookDao;
import org.example.dao.LoanDao;
import org.example.dao.ReaderDao;
import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.Reader;

import java.util.List;

public class LoanService {

    private final BookDao bookDao;
    private final ReaderDao readerDao;
    private final LoanDao loanDao;

    public LoanService(BookDao bookDao, ReaderDao readerDao, LoanDao loanDao) {
        this.bookDao = bookDao;
        this.readerDao = readerDao;
        this.loanDao = loanDao;
    }

    public void issueBook(Long bookId, Long readerId) {
        Book book = bookDao.findById(bookId);
        Reader reader = readerDao.findById(readerId);

        if (book == null) {
            System.out.println("Книга не найдена.");
            return;
        }

        if (reader == null) {
            System.out.println("Читатель не найден.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Книга уже выдана.");
            return;
        }

        Loan loan = new Loan(bookId, readerId);
        loanDao.save(loan);

        book.setAvailable(false);
        bookDao.update(book);
    }

    public void returnBook(Long bookId) {
        Book book = bookDao.findById(bookId);

        if (book == null) {
            System.out.println("Книга не найдена.");
            return;
        }

        Loan loan = loanDao.findActiveByBookId(bookId);

        if (loan == null) {
            System.out.println("Активная выдача для этой книги не найдена.");
            return;
        }

        loan.close();
        loanDao.update(loan);

        book.setAvailable(true);
        bookDao.update(book);
    }

    public List<Loan> getAllLoans() {
        return loanDao.findAll();
    }
}