package com.keybinding.servicekeybinding.api;

import com.keybinding.servicekeybinding.repo.model.Keybinding;
import com.keybinding.servicekeybinding.service.KeybindingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/keybinding")
public class KeybindingController {
    private final KeybindingService keybindingService;

    @GetMapping
    public ResponseEntity<List<Keybinding>> index() {
        final List<Keybinding> keybinding = keybindingService.fetchAll();
        return ResponseEntity.ok(keybinding);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Keybinding> show(@PathVariable long id) {
        try {
            final Keybinding keybinding = keybindingService.fetchById(id);
            return ResponseEntity.ok(keybinding);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Keybinding keybinding) {

        final char up = keybinding.getUp();
        final char down = keybinding.getDown();
        final char left = keybinding.getLeft();
        final char right = keybinding.getRight();

        final long id = keybindingService.create(up, down, left, right);
        final String location = String.format("/persons/%d", id);


        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Keybinding keybinding) {
        final char up = keybinding.getUp();
        final char down = keybinding.getDown();
        final char left = keybinding.getLeft();
        final char right = keybinding.getRight();

        try {
            keybindingService.udpate(id, up, down, left, right);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        keybindingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
