# PICOPLACA APPLICATION

PICOPLACA APPLICATION is an app for predicting which vehicles can circulate based on the last digit entered, the date of circulation, and the time of circulation.

## Features

- Restrictions: Define restrictions based on the last digit of the vehicle's plate, day of the week and hour entered.
- RestApi: Used to interact and easy integration  with Frontend applications.
- Schema: Schema and data.sql added for quick integration of restrictions into the database.

## Technologies used

- Java 17
- Maven
- Spring Boot 3.3.3
- DataBase used (PostgreSQL)
- VsCode
- SpringTool suit4
- pgAdmin4

## Installation
    git clone https://github.com/ErickDmnt/PicoPlaca.git 
    cd picoplaca

## Configuration
    application.properties

    spring.datasource.url=jdbc:postgresql://localhost:5432/pico_placa
    spring.datasource.username=erickruales
    spring.datasource.password=erick1234

    spring.datasource.dbcp2.driver-class-name=org.postgresql.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

    logging.level.org.hibernate.sql=debug
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update

    spring.servlet.multipart.max-file-size=100MB
    spring.servlet.multipart.max-request-size=100MB
    spring.mvc.static-path-pattern=/static/**

    spring.sql.init.mode=always
    spring.sql.init.schema-locations=classpath:/schema.sql
    spring.sql.init.data-locations=classpath:/data.sql




