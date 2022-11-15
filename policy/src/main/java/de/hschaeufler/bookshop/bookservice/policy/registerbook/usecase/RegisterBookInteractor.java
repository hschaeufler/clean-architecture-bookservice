package de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase;

import de.hschaeufler.bookshop.bookservice.policy.BookFactory;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.repository.RegisterBookRepository;
import de.hschaeufler.bookshop.bookservice.policy.Book;

public class RegisterBookInteractor implements RegisterBook {
    private final RegisterBookRepository registerBookRepository;
    private final BookFactory bookFactory;

    public RegisterBookInteractor(RegisterBookRepository registerBookRepository, BookFactory bookFactory) {
        this.registerBookRepository = registerBookRepository;
        this.bookFactory = bookFactory;
    }


    @Override
    public RegisterBookResponseModel registerBook(RegisterBookRequestModel registerBookRequestModel) throws BookAllreadyExistsException {
        final String isbn = registerBookRequestModel.getIsbn();
        if (registerBookRepository.existsBookByISBN(isbn)) {
            throw new BookAllreadyExistsException();
        }

        Book book = bookFactory.create(
                registerBookRequestModel.getTitle(),
                registerBookRequestModel.getAuthor(),
                registerBookRequestModel.getIsbn()
        );

        registerBookRepository.save(book);

        RegisterBookResponseModel registerBookResponseModel = new RegisterBookResponseModel(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN()
        );

        return registerBookResponseModel;
    }
}
