package de.hschaeufler.bookshop.bookservice.books;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookEntityFactoryTest {
    @Test
    @DisplayName("GIVEN nothing WHEN BookEntityFactory is instantiated THEN it should be a instance of BookFactory")
    void givenNothing_whenInstantiateBookEntityFactory_isInstanceOfBookFactory () {
        // given
        // nothing
        // when
        final BookEntityFactory actualBookEntityFactory = new BookEntityFactory();

        // then
        assertTrue(actualBookEntityFactory instanceof BookFactory);
    }

    @Test
    @DisplayName("GIVEN BookEntityFactory WHEN create is called with given values THEN it should return a Book with given values")
    void givenBookEntityFactory_whenCreateBook_thenReturnBookWithGivenValues () {
        // given
        final BookEntityFactory givenBookEntityFactory = new BookEntityFactory();
        final String givenTitle = "Clean Architecture";
        final String givenAuthor = "Uncle Book";
        final String givenISBN = "12333";

        // when
        final Book actualBook = givenBookEntityFactory.create(givenTitle, givenAuthor, givenISBN);

        // then
        final Book expectedBook = new BookEntity(givenTitle, givenAuthor, givenISBN);

        assertThat(expectedBook,samePropertyValuesAs(actualBook));
    }
}
