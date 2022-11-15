package de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase;

public interface RegisterBook {
    RegisterBookResponseModel registerBook(RegisterBookRequestModel registerBookRequestModel) throws BookAllreadyExistsException;
}
