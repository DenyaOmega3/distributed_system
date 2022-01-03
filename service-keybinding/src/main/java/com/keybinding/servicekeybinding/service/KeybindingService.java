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
        final Optional<Keybinding> maybeKeybinding = keybindingRepo.findById(id);
        if (maybeKeybinding.isEmpty()) {
            throw new IllegalArgumentException("Keybinding not found");
        }
        else {
            return maybeKeybinding.get();
        }
    }

    public long create(String up, String down, String left, String right)  {
        final Keybinding keybinding = new Keybinding(up, down, left, right);
        final Keybinding savedKeybinding = keybindingRepo.save(keybinding);

        return savedKeybinding.getId();
    }


    public void udpate(long id, String up, String down, String left, String right) throws IllegalArgumentException {
        final Optional<Keybinding> maybeKeybinding = keybindingRepo.findById(id);
        if (maybeKeybinding.isEmpty()) {
            throw new IllegalArgumentException("Person not found");
        }
        final Keybinding keybinding = maybeKeybinding.get();

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
