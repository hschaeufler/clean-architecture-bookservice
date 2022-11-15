package de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase;

import de.hschaeufler.bookshop.bookservice.policy.getbooks.repository.GetBooksRepository;

import java.util.List;

public class GetBooksInteractor implements GetBooks {

    final GetBooksRepository getBooksRepository;

    public GetBooksInteractor(GetBooksRepository getBooksRepository) {
        this.getBooksRepository = getBooksRepository;
    }

    @Override
    public List<GetBooksResponseModel> getBooks() throws NoBooksFoundException {
        throw new RuntimeException("Not Implemented yet!");
    }
}
