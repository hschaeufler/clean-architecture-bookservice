package de.hschaeufler.bookshop.bookservice.domain.registerbook.repository;

import de.hschaeufler.bookshop.bookservice.domain.Book;

public interface RegisterBookRepository {
    boolean existsBookByISBN(String isbn);
    int save(Book book);
}
