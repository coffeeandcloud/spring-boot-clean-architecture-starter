# Spring Boot Clean Architecture Starter
This project is a basic template for creating Spring Boot applications using the Clean Architecture pattern.

## Basic structure
* __Core__
    * Base: Common classes for usecase and mapper creation
        * Possible usecases are: SingleUseCase, MaybeUseCase, FlowableUseCase, ObservableUseCase
        * Mapper<I,O> to map between business logic core layer and current layer (e.g. data, controller...)
    * Domain: All your entities goes here. Use only plain POJOs or Kotlin data classes.
    * Usecases: Usecases that are needed by your application, that are inherited from baseUsecase and interact with reposities and services on core layer level.
    * Repository: Interface definition of repositories that are used by your business logic and usecases. No implementation is done here!
    * Service: Interfaces for services (internal or external) are defined here. No implementation is done here!
* __Data__
* __Controller__
* __Configuration__
    * Application: Main entry point into our Spring Boot application
    * SecurityConfig: Configuration for Spring Security goes here
    * DI: Classes for central dependency injection control
        * UsecaseDI: Define your injected usecases here
        * RepositoryDI: Define your injected repositories here
        * ServiceDI: Define your injected services here
        * MapperDI: Define your injected mappers here