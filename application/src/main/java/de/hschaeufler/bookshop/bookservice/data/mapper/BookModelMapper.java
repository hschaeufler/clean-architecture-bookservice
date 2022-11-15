package de.hschaeufler.bookshop.bookservice.data.mapper;

import de.hschaeufler.bookshop.bookservice.data.model.BookModel;
import de.hschaeufler.bookshop.bookservice.domain.Book;
import de.hschaeufler.bookshop.bookservice.domain.BookFactory;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookModelMapper {

    final BookFactory bookFactory;

    public Book toBookEntity(BookModel bookModel) {
        return bookFactory.create(
                bookModel.getTitle(),
                bookModel.getAuthor(),
                bookModel.getIsbn()
        );
    }

    public List<Book> toBookEntities(List<BookModel> bookModels) {
        return bookModels.stream()
                .map(this::toBookEntity)
                .collect(Collectors.toList());
    }

    public BookModel toBookModel(Book book) {
        return new BookModel(
                book.getISBN(),
                book.getTitle(),
                book.getAuthor()
        );
    }
}
