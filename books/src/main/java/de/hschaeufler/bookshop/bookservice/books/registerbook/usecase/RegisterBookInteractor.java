package de.hschaeufler.bookshop.bookservice.books.registerbook.usecase;

import de.hschaeufler.bookshop.bookservice.books.Book;
import de.hschaeufler.bookshop.bookservice.books.BookFactory;
import de.hschaeufler.bookshop.bookservice.books.registerbook.repository.RegisterBookRepository;

public class RegisterBookInteractor implements RegisterBookInputBoundary {
    private final RegisterBookRepository registerBookRepository;
    private final BookFactory bookFactory;

    public RegisterBookInteractor(RegisterBookRepository registerBookRepository, BookFactory bookFactory) {
        this.registerBookRepository = registerBookRepository;
        this.bookFactory = bookFactory;
    }


    @Override
    public BookResponseModel registerBook(BookRequestModel bookRequestModel) throws BookAllreadyExistsException {
        final String isbn = bookRequestModel.getIsbn();
        if (registerBookRepository.existsBookByISBN(isbn)) {
            throw new BookAllreadyExistsException();
        }

        Book book = bookFactory.create(
                bookRequestModel.getAuthor(),
                bookRequestModel.getTitle(),
                bookRequestModel.getIsbn()
        );

        registerBookRepository.save(book);

        return null;
    }
}
