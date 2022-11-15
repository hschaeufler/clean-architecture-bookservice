package de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase;

public interface RegisterBook {
    BookResponseModel registerBook(BookRequestModel bookRequestModel) throws BookAllreadyExistsException;
}
