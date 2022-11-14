package de.hschaeufler.bookshop.bookservice.books.registerbook.repository;

import de.hschaeufler.bookshop.bookservice.books.Book;

public interface RegisterBookRepository {
    boolean existsBookByISBN(String isbn);
    int save(Book book);
}
