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
  <!-- Wenn Java 9 oder höher verwendet wird-->  
    <dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
   ```
3. Danach hab ich ein MySQL Server erstellt der als Port 3306 hat und als Login Daten:
- Username: root
- passwort: root

Darauf wurde eine Konfiguration Datei erstellt, die Spring Framework über das Verbinden der Datenbank informiert. Die Datei "application.properties" die im src/main/resources Verzeichnis ist. Der Datenbank name lautet "user_db".
4. In diesem Schritt wurde im MySQL Server eine leere Datenbank erstellt mit
```
Create Database user_db;
```
Die Tabelle werden später mit der Entity Klasse automatisch erstellt.
5. Im Verzeichnis src / main / java ist ein Paket mit der Klasse "Application". Die Klasse ist der Ausgangspunkt der Anwendung und durch ausführen dieser Klasse wird die Anwendung als Webdienst ausgeführt.
```
package de.andrej.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
6. Im src / main / java Verzeichnis ist ein Paket Namens de.andrej.restservice.entity. Dadrin ist eine Klasse "ToDo", die die CRUD Schritte reinkommen.

```
package de.andrej.restservice.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {
		
	@Id private Integer id;
	private String description;
	private Date duedate;
	private Boolean done ;
	private Integer priority;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
	public String getDescription() { 
		return description;
	}
	
	
	public void setDueDate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getDueDate() {
		return duedate;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	public Boolean getDone() {
		return done;
	}
	
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPriority() {
		return priority;
	}


	@Override
	public String toString() {
		return "ToDo{" + "id='" + id + '\'' + ", description='" + description + '\'' + ", duedate='" + duedate + '\''
				+ ", done='" + done + '\'' +", priority='" + priority + '\'' + '}';
	}
}

```
Die Klasse wird mit der Anmerkung @Entity und @Id ausgezeichnet.

7. Es wurde noch ein Paket erstellt de.andrej.restservice.repository im Verzeichnis src / main / java und ein Interface "ToDoRepository".
Durch die Annotation @RestResource (exported = false), diese Anmerkung weist Spring Boot an, die Methoden nicht als REST-Endpunkte zu exportieren.
```
package de.andrej.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import de.andrej.restservice.entity.ToDo;


@RestResource(exported = false)
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {



}
```
8. Im Paket de.andrej.restservice.controller im Verzeichnis src / main / java ist eine Klasse "ToDoController".
Diese Klasse ist als RestController dekoriert und die UserRepository- Instanz wird mithilfe der Annotation @Autowired eingefügt.

HTTP Methode | URL | Beschreibung
------------ | ------------- | -------------
POST | http://localhost:8080/todo | Erstellt eine neue ID
GET | http://localhost:8080/todo | Listet alle ID's auf
GET | http://localhost:8080/todo/{id} |Listet die aufgezählte ID auf
PUT | http://localhost:8080/todo/{id} | Updated die aufgezählte ID
DELETE | http://localhost:8080/todo/{id} | Löscht die aufgezählte ID
