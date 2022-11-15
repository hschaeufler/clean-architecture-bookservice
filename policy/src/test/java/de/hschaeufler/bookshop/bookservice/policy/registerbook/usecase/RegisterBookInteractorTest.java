package de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase;

import de.hschaeufler.bookshop.bookservice.policy.Book;
import de.hschaeufler.bookshop.bookservice.policy.BookEntityFactory;
import de.hschaeufler.bookshop.bookservice.policy.BookFactory;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.repository.RegisterBookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegisterBookInteractorTest {

    @Mock
    private RegisterBookRepository registerBookRepository;
    private RegisterBook registerBook;
    private BookFactory bookFactory;

    @BeforeEach
    void setup() {
        bookFactory = new BookEntityFactory();
        registerBook = new RegisterBookInteractor(registerBookRepository, bookFactory);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(registerBookRepository);
    }


    @Test
    @DisplayName("GIVEN bookRequestModel WHEN registerBook with given Request and Book does not exist THEN should saveBook")
    void givenBookRequestModel_whenRegisterBookWithGivenRequest_thenSaveBookAndReturnResponseModle() {
        // given
        when(registerBookRepository.existsBookByISBN(any())).thenReturn(false);

        final String givenTitle = "Clean Architecture";
        final String givenAuthor = "Uncle Bob";
        final String givenISBN = "12323";

        final RegisterBookRequestModel givenRegisterBookRequestModel = new RegisterBookRequestModel(
                givenTitle,
                givenAuthor,
                givenISBN
        );

        // when
        final RegisterBookResponseModel actualRegisterBookResponseModel = registerBook.registerBook(givenRegisterBookRequestModel);

        // then
        final Book expectedBook = this.bookFactory.create(givenTitle, givenAuthor, givenISBN);
        final RegisterBookResponseModel expectedRegisterBookResponseModel = new RegisterBookResponseModel(givenTitle, givenAuthor, givenISBN);

        verify(registerBookRepository).existsBookByISBN(givenISBN);
        verify(registerBookRepository).save(refEq(expectedBook));
        assertThat(actualRegisterBookResponseModel, samePropertyValuesAs(expectedRegisterBookResponseModel));
    }

    @Test
    @DisplayName("GIVEN bookRequestModel WHEN registerBook and Book does exist THEN should throw Exception and not save Book")
    void givenBookRequestModel_whenRegisterBookWithExistingISBN_thenThrowBooksAllreadyExistsException() {
        // given
        when(registerBookRepository.existsBookByISBN(any())).thenReturn(true);

        final String givenTitle = "Clean Architecture";
        final String givenAuthor = "Uncle Bob";
        final String givenISBN = "12323";

        final RegisterBookRequestModel givenRegisterBookRequestModel = new RegisterBookRequestModel(
                givenTitle,
                givenAuthor,
                givenISBN
        );

        // when
        assertThrows(BookAllreadyExistsException.class, () -> registerBook.registerBook(givenRegisterBookRequestModel));

        // then
        verify(registerBookRepository, never()).save(any());
    }
}
