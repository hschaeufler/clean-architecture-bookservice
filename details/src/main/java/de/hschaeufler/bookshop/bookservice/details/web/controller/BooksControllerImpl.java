package de.hschaeufler.bookshop.bookservice.details.web.controller;

import de.hschaeufler.bookshop.bookservice.details.web.mapper.GetBooksResponseMapper;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.RegisterBookRequestMapper;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.RegisterBookResponseMapper;
import de.hschaeufler.bookshop.bookservice.details.web.model.GetBooksResponseDTO;
import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookRequestDTO;
import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookResponseDTO;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooksResponseModel;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooks;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.NoBooksFoundException;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.BookAllreadyExistsException;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.RegisterBook;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
public class BooksControllerImpl implements GetBooksController, RegisterBookController {

    final GetBooks getBooks;
    final GetBooksResponseMapper getBooksResponseMapper;
    final RegisterBook registerBook;
    final RegisterBookRequestMapper registerBookRequestMapper;
    final RegisterBookResponseMapper registerBookResponseMapper;


    @GetMapping("/books")
    public List<GetBooksResponseDTO> getBooks() {
        try {
            final List<GetBooksResponseModel> getBooksResponseModelList = getBooks.getBooks();
            return this.getBooksResponseMapper.toResponseDTOs(getBooksResponseModelList);
        } catch (NoBooksFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Books Found!", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "I'm a Teapot!", e);
        }

    }

    @PostMapping("/books")
    public RegisterBookResponseDTO registerBook(RegisterBookRequestDTO registerBookRequestDTO) {
        try {
            final var registerBookRequestModel = this.registerBookRequestMapper
                    .toRequestModel(registerBookRequestDTO);

            final var registerBookResponseModel = this.registerBook
                    .registerBook(registerBookRequestModel);

            return this.registerBookResponseMapper.toResponseDTO(registerBookResponseModel);

        } catch (BookAllreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Oh oh, Book already exists!", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "I'm a Teapot!", e);
        }

    }

}
