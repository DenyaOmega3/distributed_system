package com.personcreation.serviceperson.api;

import com.personcreation.serviceperson.service.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public final class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<com.personcreation.serviceperson.repo.model.Person>> index() {
        final List<com.personcreation.serviceperson.repo.model.Person> persons = personService.fetchAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.personcreation.serviceperson.repo.model.Person> show(@PathVariable long id) {
        try {
            final com.personcreation.serviceperson.repo.model.Person person = personService.fetchById(id);
            return ResponseEntity.ok(person);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.personcreation.serviceperson.api.dto.Person person) {
        final String username = person.getUsername();
        final long level = person.getLevel();
        final long gold = person.getGold();
        final long platinum = person.getPlatinum();
        final long id = personService.create(username, level, gold, platinum);
        final String location = String.format("/persons/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.personcreation.serviceperson.api.dto.Person person) {
        final String username = person.getUsername();
        final long level = person.getLevel();
        final long gold = person.getGold();
        final long platinum = person.getPlatinum();

        try {
            personService.udpate(id, username, level, gold, platinum);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
