package de.hschaeufler.bookshop.bookservice.details.config;

import de.hschaeufler.bookshop.bookservice.details.data.datasource.BookDAO;
import de.hschaeufler.bookshop.bookservice.details.data.mapper.BookModelMapper;
import de.hschaeufler.bookshop.bookservice.details.data.repository.BookRepositoryImpl;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.RegisterBookRequestMapper;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.RegisterBookResponseMapper;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.GetBooksResponseMapper;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.repository.GetBooksRepository;
import de.hschaeufler.bookshop.bookservice.policy.BookEntityFactory;
import de.hschaeufler.bookshop.bookservice.policy.BookFactory;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooks;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooksInteractor;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.repository.RegisterBookRepository;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.RegisterBook;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.RegisterBookInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookServiceConfig {

    @Bean
    public BookFactory bookFactory(){
        return new BookEntityFactory();
    }

    @Bean
    public GetBooks getBooks(GetBooksRepository getBooksRepository){
        return new GetBooksInteractor(getBooksRepository);
    }

    @Bean
    public RegisterBook registerBook(RegisterBookRepository registerBookRepository, BookFactory bookFactory){
        return new RegisterBookInteractor(registerBookRepository, bookFactory);
    }

    @Bean
    public BookRepositoryImpl bookRepository(BookDAO bookDAO, BookModelMapper bookModelMapper){
        return new BookRepositoryImpl(bookDAO, bookModelMapper);
    }

    @Bean
    public BookModelMapper bookModelMapper(BookFactory bookFactory) {
        return new BookModelMapper(bookFactory);
    }

    @Bean
    public RegisterBookRepository registerBookRepository(BookRepositoryImpl bookRepository){
        return bookRepository;
    }

    @Bean
    public GetBooksRepository getBooksRepository(BookRepositoryImpl bookRepository){
        return bookRepository;
    }

    @Bean
    public RegisterBookRequestMapper registerBookRequestMapper(){
        return new RegisterBookRequestMapper();
    }

    @Bean
    public RegisterBookResponseMapper registerBookResponseMapper(){
        return new RegisterBookResponseMapper();
    }

    @Bean
    public GetBooksResponseMapper getBooksResponseMapper(){
        return new GetBooksResponseMapper();
    }
}
