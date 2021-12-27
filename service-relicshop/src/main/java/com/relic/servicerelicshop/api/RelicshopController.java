package com.relic.servicerelicshop.api;

import com.relic.servicerelicshop.repo.model.Relicshop;
import com.relic.servicerelicshop.service.RelicshopService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/relicshop")
public final class RelicshopController {

    private final RelicshopService relicshopService;

    @GetMapping
    public ResponseEntity<List<Relicshop>> index() {
        final List<Relicshop> relicshops = relicshopService.fetchAll();
        return ResponseEntity.ok(relicshops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relicshop> show(@PathVariable long id) {
        try {
            final Relicshop relicshop = relicshopService.fetchById(id);
            return ResponseEntity.ok(relicshop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.relic.servicerelicshop.repo.model.Relicshop relicshop) {
        final String name = relicshop.getRelic_name();
        final long goldPrice = relicshop.getGoldPrice();
        final long platinumPrice = relicshop.getPlatinumPrice();
        final String buff = relicshop.getBuff();
        final String description = relicshop.getDescription();

        final long id = relicshopService.create(name, goldPrice, platinumPrice, buff, description);
        final String location = String.format("/relicshop/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.relic.servicerelicshop.repo.model.Relicshop relicshop) {
        final String name = relicshop.getRelic_name();
        final long goldPrice = relicshop.getGoldPrice();
        final long platinumPrice = relicshop.getPlatinumPrice();
        final String buff = relicshop.getBuff();
        final String description = relicshop.getDescription();

        try {
            relicshopService.udpate(id, name, goldPrice, platinumPrice, buff, description);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        relicshopService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
