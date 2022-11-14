package de.hschaeufler.bookshop.bookservice.books.registerbook.usecase;

public interface RegisterBook {
    BookResponseModel registerBook(BookRequestModel bookRequestModel) throws BookAllreadyExistsException;
}
