# Clean Architecture Bookshop
This application is a rest service for storing and retrieving books. The architecture is based on Uncle Bob's Clean Architecture Style and was developed for a Team Teaching on Clean Architecture  in the course of the lecture Software Quality Engineering.
## Details
The application uses Java 17 and Spring Boot. The books are stored in an H2 inmemory database.
The Maven module ``Policy`` contains all the business objects and rules. The ``Details`` Module contains all the InterfaceAdapter and the Glue Code.
The ``testdata`` folder contains a collection of request messages for Postman.
## Challenges
The students have to solve several challenges. These are implemented via individual Git branches.
### Current Challenge
Current Challenge is Challenge Nr. 2:
```
Implement the GetBooksRepository in the BookRepositoryImpl class.
- The necessary classes can be found in the details module in the data folder.
- Use the branch lecture/challange-two-repository (git checkout)
- The RegisterBookRepository can be used for orientation.
- There is a mapper for converting the BookModel to an entity.
- At the DataAccesObject (BookDAO) there is the method findAll()
- Insert the following lines into the BookServiceConfig

@Bean
public GetBooksRepository getBooksRepository(BookRepositoryImpl bookRepository) {
    return bookRepository;
}
@Bean
public GetBooks getBooks(GetBooksRepository getBooksRepository) {
    return new GetBooksInteractor(getBooksRepository);
}
```
## Getting Started
Clone the project with ``git clone``. You need the JDK 17, an IDE and Maven. After the repository is cloned, you can call mvn install in the parent module to resolve the dependencies.  With ``mvn spring-boot:run`` you can execute the service.

