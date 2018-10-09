![](https://source.unsplash.com/tvPvROBv0F4/1600x800)

# Spring Boot Clean Architecture Starter
This project is a basic template for creating Spring Boot applications using the Clean Architecture pattern.

## Basic structure
### Core
The core layer contains the base implementations for the Clean Architecture and core entities and usecase definitions.
* __Base:__ Common classes for usecase and mapper creation
    * Possible usecases are: SingleUseCase, MaybeUseCase, FlowableUseCase, ObservableUseCase
    * Mapper<I,O> to map between business logic core layer and current layer (e.g. data, controller...)
* __Domain:__ All your entities goes here. Use only plain POJOs or Kotlin data classes.
* __Usecases:__ Usecases that are needed by your application, that are inherited from baseUsecase and interact with reposities and services on core layer level.
* __Repository:__ Interface definition of repositories that are used by your business logic and usecases. No implementation is done here!
* __Service:__ Interfaces for services (internal or external) are defined here. No implementation is done here!
### Data 
Repository interfaces from core layer must be implemented here.
### Service
Implement your service interfaces on the service layer.
### Controller 
Exposing your business logic via an API is done on the controller layer. No domain logic should be implemented here, just make use of the usecases.
### Configuration
This layer is used to configure your whole application and wire the abstractions together.
* __Application:__ Main entry point into our Spring Boot application
* __SecurityConfig:__ Configuration for Spring Security goes here
* __DI:__ Classes for central dependency injection control
    * UsecaseDI: Define your injected usecases here
    * RepositoryDI: Define your injected repositories here
    * ServiceDI: Define your injected services here
    * MapperDI: Define your injected mappers here