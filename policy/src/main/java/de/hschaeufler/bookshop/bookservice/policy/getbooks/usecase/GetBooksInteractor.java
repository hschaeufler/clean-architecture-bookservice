package de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase;

import de.hschaeufler.bookshop.bookservice.policy.Book;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.repository.GetBooksRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetBooksInteractor implements GetBooks {

    final GetBooksRepository getBooksRepository;

    public GetBooksInteractor(GetBooksRepository getBooksRepository) {
        this.getBooksRepository = getBooksRepository;
    }

    @Override
    public List<GetBooksResponseModel> getBooks() throws NoBooksFoundException {
        final List<Book> books = this.getBooksRepository.getBooks();

        if (books.isEmpty()) {
            throw new NoBooksFoundException();
        }

        return books.stream().map(book -> new GetBooksResponseModel(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN(),
                books.indexOf(book)
        )).collect(Collectors.toList());

    }
}
