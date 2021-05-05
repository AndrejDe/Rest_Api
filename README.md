## Inhalt
1. [Einführung](#einführung)
2. [Programme](#programme)
3. [Gedankengänge](#gedankengänge)

### Einführung
***
Implementieren Sie die in todo.json angegebene Rest-API.

## Programme
***
Eine Liste welche Programme ich benutzt habe:
- Eclipse IDE
- MySQL
- Postman

## Gedankengänge
***
1. Es wurde mit dem Spring initializr (https://start.spring.io/) ein Maven Projekt erstellt mit den Dependencies "Spring Web" und "JPA".
2. Danach habe ich in der pom.xml geöffnet und das Projekt als Spring Boot definiert mit den vorgebenen Dependencies und die Datenbank verbunden.
```
<!-- Spring Boot -->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
 <!-- MySQL Connector -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    </dependencies>
    ```
