package com.personcreation.serviceperson.service;

import com.personcreation.serviceperson.repo.PersonRepo;
import com.personcreation.serviceperson.repo.model.Person;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public final class PersonService {

    private final PersonRepo personRepo;

    public List<Person> fetchAll() {
        return personRepo.findAll();
    }

    public Person fetchById(long id) throws IllegalArgumentException {
        final Optional<Person> maybePerson = personRepo.findById(id);
        if (maybePerson.isEmpty()) {
            throw new IllegalArgumentException("Person not found");
        }
        else {
            return maybePerson.get();
        }
    }

    public long create(String username, long level, long gold, long platinum)  {
        final Person person = new Person(username, level, gold, platinum);
        final Person savedPerson = personRepo.save(person);

        return savedPerson.getId();
    }

    public void udpate(long id, String username, long level, long gold, long platinum) throws IllegalArgumentException {
        final Optional<Person> maybePerson = personRepo.findById(id);
        if (maybePerson.isEmpty()) {
            throw new IllegalArgumentException("Person not found");
        }
        final Person person = maybePerson.get();
        if (username != null & !username.isBlank()) {
            person.setUsername(username);
        }
        person.setLevel(level);
        person.setGold(gold);
        person.setPlatinum(platinum);

        personRepo.save(person);
    }

    public void delete(long id) {
        personRepo.deleteById(id);
    }
}
