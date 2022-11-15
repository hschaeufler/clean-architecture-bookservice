package de.hschaeufler.bookshop.bookservice.policy.registerbook.repository;

import de.hschaeufler.bookshop.bookservice.policy.Book;

public interface RegisterBookRepository {
    boolean existsBookByISBN(String isbn);

    int save(Book book);
}
