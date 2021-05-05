package de.andrej.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.andrej.restservice.entity.ToDo;
import de.andrej.restservice.repository.ToDoRepository;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository repository;

    @GetMapping
    public Iterable<ToDo> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ToDo find(@PathVariable("id") Integer id) {
        return repository.findOne(id);
    }
    
 
   
    @PostMapping(consumes = "application/json")
    public ToDo create(@RequestBody ToDo todo) {
        return repository.save(todo); 
       
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public ToDo update(@PathVariable("id") Integer id, @RequestBody ToDo todo) throws BadHttpRequest {
        if (repository.exists(id)) {
            todo.setId(id);
            return repository.save(todo);
        } else {
            throw new BadHttpRequest();
        }
    }
}