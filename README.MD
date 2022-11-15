# Clean Architecture Bookshop
This application is a rest service for storing and retrieving books. The architecture is based on Uncle Bob's Clean Architecture Style and was developed for a Team Teaching on Clean Architecture  in the course of the lecture Software Quality Engineering.
## Details
The application uses Java 17 and Spring Boot. The books are stored in an H2 inmemory database.
The Maven module ``Policy`` contains all the business objects and rules. The ``Details`` Module contains all the InterfaceAdapter and the Glue Code.
The ``testdata`` folder contains a collection of request messages for Postman.
## Challenges
The students have to solve several challenges. These are implemented via individual Git branches.
### Current Challenge
Current Challenge is Challenge Nr. 3:
```
Implement the getBooks method in the BooksControllerImpl class.
-   Use the branch lecture/challange-three-controller (git checkout)
-   The registerBook method can be used for orientation
-   Implement the GetBooksController interface for this purpose
-   The method should be callable via GET and under the endpoint /books
-   There is a mapper for the conversion of the ResponseModel to the DTO
-   Use the HTTPStatus.NOT_FOUND for the NoBooksFoundException
-   Include the GetBooks-Usecase
-   You can test the function via Postman
```
## Getting Started
Clone the project with ``git clone``. You need the JDK 17, an IDE and Maven. After the repository is cloned, you can call mvn install in the parent module to resolve the dependencies.  With ``mvn spring-boot:run`` you can execute the service.

