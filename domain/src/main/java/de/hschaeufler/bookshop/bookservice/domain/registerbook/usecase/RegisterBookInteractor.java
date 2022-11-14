package de.hschaeufler.bookshop.bookservice.domain.registerbook.usecase;

import de.hschaeufler.bookshop.bookservice.domain.Book;
import de.hschaeufler.bookshop.bookservice.domain.BookFactory;
import de.hschaeufler.bookshop.bookservice.domain.registerbook.repository.RegisterBookRepository;

public class RegisterBookInteractor implements RegisterBook {
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
                bookRequestModel.getTitle(),
                bookRequestModel.getAuthor(),
                bookRequestModel.getIsbn()
        );

        registerBookRepository.save(book);

        BookResponseModel bookResponseModel = new BookResponseModel(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN()
        );

        return bookResponseModel;
    }
}
