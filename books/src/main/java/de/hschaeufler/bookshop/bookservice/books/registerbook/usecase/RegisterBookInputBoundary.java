package de.hschaeufler.bookshop.bookservice.books.registerbook.usecase;

public interface RegisterBookInputBoundary {
    BookResponseModel registerBook(BookRequestModel bookRequestModel) throws BookAllreadyExistsException;
}
