# Clean Architecture Bookshop
This application is a rest service for storing and retrieving books. The architecture is based on Uncle Bob's Clean Architecture Style and was developed for a Team Teaching on Clean Architecture  in the course of the lecture Software Quality Engineering.
## Details
The application uses Java 17 and Spring Boot. The books are stored in an H2 inmemory database.
The Maven module ``Policy`` contains all the business objects and rules. The ``Details`` Module contains all the InterfaceAdapter and the Glue Code.
The ``testdata`` folder contains a collection of request messages for Postman.
## Challenges
The students have to solve several challenges. These are implemented via individual Git branches.
