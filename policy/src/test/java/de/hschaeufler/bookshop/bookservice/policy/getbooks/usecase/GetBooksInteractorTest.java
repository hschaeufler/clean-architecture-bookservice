package de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase;

import de.hschaeufler.bookshop.bookservice.policy.BookEntityFactory;
import de.hschaeufler.bookshop.bookservice.policy.BookFactory;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.repository.GetBooksRepository;
import de.hschaeufler.bookshop.bookservice.policy.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetBooksInteractorTest {


    @Mock
    private GetBooksRepository getBooksRepository;
    private GetBooks getBooks;
    private BookFactory bookFactory;

    @BeforeEach
    void setup() {
        bookFactory = new BookEntityFactory();
        getBooks = new GetBooksInteractor(getBooksRepository);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(getBooksRepository);
    }


    @Test
    @DisplayName("GIVEN bookRequestModel WHEN registerBook with given Request and Book does not exist THEN should saveBook")
    void givenBookRequestModel_whenRegisterBookWithGivenRequest_thenSaveBookAndReturnResponseModle() {
        // given

        final String givenTitle = "Clean Architecture";
        final String givenAuthor = "Uncle Bob";
        final String givenISBN = "12323";

        BookFactory bookFactory = new BookEntityFactory();
        List<Book> bookList = new ArrayList<>();
        bookList.add(
                bookFactory.create(givenTitle,givenAuthor,givenISBN)
        );
        bookList.add(
                bookFactory.create(givenTitle,givenAuthor,givenISBN)
        );

        when(getBooksRepository.getBooks()).thenReturn(bookList);

        // when
        final List<GetBooksResponseModel> actualGetBooksResponseModelList = getBooks.getBooks();


        // then
        verify(getBooksRepository,times(1)).getBooks();

        final List<GetBooksResponseModel> expectedGetBooksResponseModel = new ArrayList<>();
        expectedGetBooksResponseModel.add(new GetBooksResponseModel(
                givenTitle,givenAuthor,givenISBN,0
        ));
        expectedGetBooksResponseModel.add(new GetBooksResponseModel(
                givenTitle,givenAuthor,givenISBN,1
        ));

        assertThat(actualGetBooksResponseModelList, samePropertyValuesAs(expectedGetBooksResponseModel));

    }
}
