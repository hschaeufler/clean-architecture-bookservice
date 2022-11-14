package de.hschaeufler.bookshop.bookservice.books.getbooks.usecase;

import de.hschaeufler.bookshop.bookservice.books.Book;
import de.hschaeufler.bookshop.bookservice.books.getbooks.repository.GetBookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetBooksInteractor implements GetBooks {

    final GetBookRepository getBookRepository;

    public GetBooksInteractor(GetBookRepository getBookRepository) {
        this.getBookRepository = getBookRepository;
    }

    @Override
    public List<BookResponseModel> getBooks() throws NoBooksFoundException{
        final List<Book> books = this.getBookRepository.getBooks();

        if(books.isEmpty()) {
            throw new NoBooksFoundException();
        }

        return books.stream().map(book -> new BookResponseModel(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN(),
                books.indexOf(book)
        )).collect(Collectors.toList());

    }
}
