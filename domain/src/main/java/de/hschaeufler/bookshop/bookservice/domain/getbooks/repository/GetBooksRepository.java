package de.hschaeufler.bookshop.bookservice.domain.getbooks.repository;

import de.hschaeufler.bookshop.bookservice.domain.Book;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.NoBooksFoundException;

import java.util.List;

public interface GetBooksRepository {
 List<Book> getBooks();
}
