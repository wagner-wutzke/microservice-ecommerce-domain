---
name: create-jpa-entities-mappers
description: Create JPA Entity and DTO's classes from Avro object schemas and their Mapper classes.
---

# Generate JPA Entities, DTO's and Mappers
In order to have a maven project with all domain objects, this project is generating all common classes
and centralizing it, so that other projects can use it as dependency.

## DTO classes generation

- Configure the Avro Maven plugin to auto-generate Java classes from schemas during the compile phase.


## JPA Entity classes generation

- Create a Jakarta JPA Entity class for each generated domain object class in `net.wowdev.microservice.ecommerce.dto`.
- Add the proper Jakarta annotations for each column / field in the classes.
- Add the audit annotations to fields `createdAt` and `modifiedAt` to all entity classes, along with the
  `@EntityListeners(AuditingEntityListener.class)` annotation.
- Create the generated enums counterparts in the entity package. 
- Add Jakarta Persistence `@Column` annotations to entity classes accordingly.
- Add an empty line in the code after each declared column.


## Entity / DTO Mapper classes generation

- Create a Mapper class for each generated domain object class in `net.wowdev.microservice.ecommerce.dto`.
- Keep generated Avro types out of controller and repository APIs.
- The Mapper classes shall convert objects from Avro/DTO format into JPA Entitiy and from JPA Entity into Avro/DTO
  object.
- Always use the Avro-generated `.newBuilder()...build()` pattern when instantiating objects.
- Every single assignment following a builder method must be placed on its own individual line.
- Every single argument inside the constructor must be placed on its own individual line.
- Put the Mapper classes in the `net.wowdev.microservice.ecommerce.mapper` package.


# General Rules

- Always use Lombok annotations (`getters`, `setter`, `NoArgConstructor`, `AllArgConstructor`, etc.) for all generated
  classes.
- Create Unit Test classes (having at least 95% coverage) for each generated class.
- Follow Google Java coding style convention for all generated classes.
- Keep the code modular, well-commented, and compliant with clean code principles.
- Never use `var` declaration. Use the expected variable type instead.