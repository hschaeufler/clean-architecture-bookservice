package de.hschaeufler.bookshop.bookservice.data.repository;

import de.hschaeufler.bookshop.bookservice.data.datasource.BookDAO;
import de.hschaeufler.bookshop.bookservice.data.mapper.BookModelMapper;
import de.hschaeufler.bookshop.bookservice.data.model.BookModel;
import de.hschaeufler.bookshop.bookservice.domain.Book;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.repository.GetBooksRepository;
import de.hschaeufler.bookshop.bookservice.domain.registerbook.repository.RegisterBookRepository;

import java.util.List;

public class BookRepositoryImpl implements RegisterBookRepository, GetBooksRepository {

    private final BookDAO bookDAO;
    private final BookModelMapper bookModelMapper;

    public BookRepositoryImpl(BookDAO bookDAO, BookModelMapper bookModelMapper) {
        this.bookDAO = bookDAO;
        this.bookModelMapper = bookModelMapper;
    }

    @Override
    public boolean existsBookByISBN(String isbn) {
        return this.bookDAO.existsById(isbn);
    }

    @Override
    public int save(Book book) {
        final BookModel bookModel = this.bookModelMapper.toBookModel(book);
        this.bookDAO.save(bookModel);
        return (int) this.bookDAO.count();
    }

    @Override
    public List<Book> getBooks() {
        final List<BookModel> bookModels = this.bookDAO.findAll();
        return this.bookModelMapper.toBookEntities(bookModels);
    }
}
