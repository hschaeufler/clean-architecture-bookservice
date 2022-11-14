package de.hschaeufler.bookshop.bookservice.web.controller;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.BookResponseModel;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.GetBooks;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    final GetBooks getBooks;

    @GetMapping("/books")
    List<BookResponseModel> sayHello(){
        return getBooks.getBooks();
    }

}
