package de.andrej.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import de.andrej.restservice.entity.ToDo;


@RestResource(exported = false)
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {



}