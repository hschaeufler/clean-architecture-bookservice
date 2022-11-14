package de.hschaeufler.bookshop.bookservice.books.registerbook.usecase;

import de.hschaeufler.bookshop.bookservice.books.Book;
import de.hschaeufler.bookshop.bookservice.books.BookEntityFactory;
import de.hschaeufler.bookshop.bookservice.books.BookFactory;
import de.hschaeufler.bookshop.bookservice.books.registerbook.repository.RegisterBookRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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

        final BookRequestModel givenBookRequestModel = new BookRequestModel(
                givenTitle,
                givenAuthor,
                givenISBN
        );

        // when
        final BookResponseModel actualBookResponseModel = registerBook.registerBook(givenBookRequestModel);

        // then
        final Book expectedBook = this.bookFactory.create(givenTitle, givenAuthor, givenISBN);
        final BookResponseModel expectedBookResponseModel = new BookResponseModel(givenTitle, givenAuthor, givenISBN);

        verify(registerBookRepository).existsBookByISBN(givenISBN);
        verify(registerBookRepository).save(refEq(expectedBook));
        assertThat(actualBookResponseModel, samePropertyValuesAs(expectedBookResponseModel));
    }

    @Test
    @DisplayName("GIVEN bookRequestModel WHEN registerBook and Book does exist THEN should throw Exception and not save Book")
    void givenBookRequestModel_whenRegisterBookWithExistingISBN_thenThrowBooksAllreadyExistsException() {
        // given
        when(registerBookRepository.existsBookByISBN(any())).thenReturn(true);

        final String givenTitle = "Clean Architecture";
        final String givenAuthor = "Uncle Bob";
        final String givenISBN = "12323";

        final BookRequestModel givenBookRequestModel = new BookRequestModel(
                givenTitle,
                givenAuthor,
                givenISBN
        );

        // when
        assertThrows(BookAllreadyExistsException.class, () -> registerBook.registerBook(givenBookRequestModel));

        // then
        verify(registerBookRepository, never()).save(any());
    }
}
