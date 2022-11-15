package de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase;

import java.util.List;

public interface GetBooks {
    List<BookResponseModel> getBooks() throws NoBooksFoundException;
}
