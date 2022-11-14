package de.hschaeufler.bookshop.bookservice.books.getbooks.repository;

import de.hschaeufler.bookshop.bookservice.books.Book;
import de.hschaeufler.bookshop.bookservice.books.getbooks.usecase.NoBooksFoundException;

import java.util.List;

public interface GetBookRepository {
 List<Book> getBooks() throws NoBooksFoundException;
}
