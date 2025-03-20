package com.example.demo.controller;

import com.example.demo.dto.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/person")
    public Iterable<Person> getPerson() {
        return repository.findAll();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable("id") int id) {
        return repository.findById(id);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        person.setId(id);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

}
