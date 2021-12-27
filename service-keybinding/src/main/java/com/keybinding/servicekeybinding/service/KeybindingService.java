package com.keybinding.servicekeybinding.service;

import com.keybinding.servicekeybinding.repo.KeybindingRepo;
import com.keybinding.servicekeybinding.repo.model.Keybinding;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KeybindingService {
    private final KeybindingRepo keybindingRepo;

    public List<Keybinding> fetchAll() {
        return keybindingRepo.findAll();
    }

    public Keybinding fetchById(long id) throws IllegalArgumentException {
        final Optional<Keybinding> maybePerson = keybindingRepo.findById(id);
        if (maybePerson.isEmpty()) {
            throw new IllegalArgumentException("Keybinding not found");
        }
        else {
            return maybePerson.get();
        }
    }

    public long create(char up, char down, char left, char right)  {
        final Keybinding person = new Keybinding(up, down, left, right);
        final Keybinding savedPerson = keybindingRepo.save(person);

        return savedPerson.getId();
    }

    public void udpate(long id, char up, char down, char left, char right) throws IllegalArgumentException {
        final Optional<Keybinding> maybePerson = keybindingRepo.findById(id);
        if (maybePerson.isEmpty()) {
            throw new IllegalArgumentException("Person not found");
        }
        final Keybinding keybinding = maybePerson.get();

        keybinding.setUp(up);
        keybinding.setDown(down);
        keybinding.setLeft(left);
        keybinding.setRight(right);

        keybindingRepo.save(keybinding);
    }

    public void delete(long id) {
        keybindingRepo.deleteById(id);
    }
}
