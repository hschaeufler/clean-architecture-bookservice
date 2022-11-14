package de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase;

import java.util.List;

public interface GetBooks {
    List<BookResponseModel> getBooks() throws NoBooksFoundException;
}
