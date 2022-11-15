package de.hschaeufler.bookshop.bookservice.details.web.controller;

import de.hschaeufler.bookshop.bookservice.details.web.mapper.GetBooksResponseMapper;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.RegisterBookRequestMapper;
import de.hschaeufler.bookshop.bookservice.details.web.mapper.RegisterBookResponseMapper;
import de.hschaeufler.bookshop.bookservice.details.web.model.GetBooksResponseDTO;
import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookRequestDTO;
import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookResponseDTO;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooks;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooksResponseModel;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.NoBooksFoundException;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.BookAllreadyExistsException;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.RegisterBook;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksControllerImpl implements RegisterBookController {
    Logger logger = LoggerFactory.getLogger(BooksControllerImpl.class);

    final RegisterBook registerBook;
    final RegisterBookRequestMapper registerBookRequestMapper;
    final RegisterBookResponseMapper registerBookResponseMapper;


    @PostMapping("/books")
    public RegisterBookResponseDTO registerBook(@RequestBody RegisterBookRequestDTO registerBookRequestDTO) {
        try {
            logger.info(registerBookRequestDTO.getIsbn());

            final var registerBookRequestModel = this.registerBookRequestMapper
                    .toRequestModel(registerBookRequestDTO);

            logger.info(registerBookRequestModel.getIsbn());

            final var registerBookResponseModel = this.registerBook
                    .registerBook(registerBookRequestModel);

            return this.registerBookResponseMapper.toResponseDTO(registerBookResponseModel);

        } catch (BookAllreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oh no! Book already exists!", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "I'm a Teapot!", e);
        }

    }

}
