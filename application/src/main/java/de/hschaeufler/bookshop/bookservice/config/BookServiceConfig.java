package de.hschaeufler.bookshop.bookservice.config;

import de.hschaeufler.bookshop.bookservice.data.datasource.BookDAO;
import de.hschaeufler.bookshop.bookservice.data.mapper.BookModelMapper;
import de.hschaeufler.bookshop.bookservice.data.repository.BookRepositoryImpl;
import de.hschaeufler.bookshop.bookservice.domain.BookEntityFactory;
import de.hschaeufler.bookshop.bookservice.domain.BookFactory;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.repository.GetBooksRepository;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.GetBooks;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.GetBooksInteractor;
import de.hschaeufler.bookshop.bookservice.domain.registerbook.repository.RegisterBookRepository;
import de.hschaeufler.bookshop.bookservice.domain.registerbook.usecase.RegisterBook;
import de.hschaeufler.bookshop.bookservice.domain.registerbook.usecase.RegisterBookInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookServiceConfig {

    @Bean
    BookFactory bookFactory(){
        return new BookEntityFactory();
    }

    @Bean
    GetBooks getBooks(GetBooksRepository getBooksRepository){
        return new GetBooksInteractor(getBooksRepository);
    }

    @Bean
    RegisterBook registerBook(RegisterBookRepository registerBookRepository, BookFactory bookFactory){
        return new RegisterBookInteractor(registerBookRepository, bookFactory);
    }

    @Bean
    BookRepositoryImpl bookRepository(BookDAO bookDAO, BookModelMapper bookModelMapper){
        return new BookRepositoryImpl(bookDAO, bookModelMapper);
    }

    @Bean
    BookModelMapper bookModelMapper(BookFactory bookFactory) {
        return new BookModelMapper(bookFactory);
    }

    @Bean
    RegisterBookRepository registerBookRepository(BookRepositoryImpl bookRepository){
        return bookRepository;
    }

    @Bean
    GetBooksRepository getBooksRepository(BookRepositoryImpl bookRepository){
        return bookRepository;
    }
}
