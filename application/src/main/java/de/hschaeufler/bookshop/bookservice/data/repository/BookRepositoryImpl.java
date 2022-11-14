package de.hschaeufler.bookshop.bookservice.data.repository;

import de.hschaeufler.bookshop.bookservice.data.datasource.BookDAO;
import de.hschaeufler.bookshop.bookservice.domain.Book;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.repository.GetBooksRepository;
import de.hschaeufler.bookshop.bookservice.domain.registerbook.repository.RegisterBookRepository;

import java.util.List;

public class BookRepositoryImpl implements RegisterBookRepository, GetBooksRepository {

    private final BookDAO bookDAO;

    public BookRepositoryImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean existsBookByISBN(String isbn) {
        return this.bookDAO.existsById(isbn);
    }

    @Override
    public int save(Book book) {
        return 0;
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }
}
