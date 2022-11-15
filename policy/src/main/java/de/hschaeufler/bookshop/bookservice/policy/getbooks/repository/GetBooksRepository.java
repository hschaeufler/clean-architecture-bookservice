package de.hschaeufler.bookshop.bookservice.policy.getbooks.repository;

import de.hschaeufler.bookshop.bookservice.policy.Book;

import java.util.List;

public interface GetBooksRepository {
 List<Book> getBooks();
}
