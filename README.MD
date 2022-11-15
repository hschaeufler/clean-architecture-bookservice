# Clean Architecture Bookshop
This application is a rest service for storing and retrieving books. The architecture is based on Uncle Bob's Clean Architecture Style and was developed for a Team Teaching on Clean Architecture  in the course of the lecture Software Quality Engineering.
## Details
The application uses Java 17 and Spring Boot. The books are stored in an H2 inmemory database.
The Maven module ``Policy`` contains all the business objects and rules. The ``Details`` Module contains all the InterfaceAdapter and the Glue Code.
The ``testdata`` folder contains a collection of request messages for Postman.
## Challenges
The students have to solve several challenges. These are implemented via individual Git branches.
### Current Challenge
Current Challenge is Challenge Nr. 1:
```
Implement the UseCase GetBooks in the GetBooksInteractor class.
- The necessary classes can be found in the policy module in the getBooks folder.
- Use the branch lecture/challange-one-domain (git checkout)
- Use the GetBooksRepository to find the books
- For the conversion of the BookModel to the Entity there is a Mapper
- If there are no books, a NoBooksFoundException should be thrown.
- Tests the functionality with the already implemented unit tests (TDD).
- The entity can be mapped to the response model via the following line

return books.stream().map(book -> new GetBooksResponseModel(
        book.getTitle(),
        book.getAuthor(),
        book.getISBN(),
        books.indexOf(book)
)).collect(Collectors.toList());

```
## Getting Started
Clone the project with ``git clone``. You need the JDK 17, an IDE and Maven. After the repository is cloned, you can call mvn install in the parent module to resolve the dependencies.  With ``mvn spring-boot:run`` you can execute the service.

