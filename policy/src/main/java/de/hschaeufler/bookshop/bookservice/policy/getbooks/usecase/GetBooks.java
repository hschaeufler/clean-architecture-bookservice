package de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase;

import java.util.List;

public interface GetBooks {
    List<GetBooksResponseModel> getBooks() throws NoBooksFoundException;
}
