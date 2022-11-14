package de.hschaeufler.bookshop.bookservice.domain.registerbook.usecase;

public interface RegisterBook {
    BookResponseModel registerBook(BookRequestModel bookRequestModel) throws BookAllreadyExistsException;
}
