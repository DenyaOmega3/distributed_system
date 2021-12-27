package com.relic.servicerelicshop.service;


import java.util.List;
import java.util.Optional;

import com.relic.servicerelicshop.repo.RelicshopRepo;
import com.relic.servicerelicshop.repo.model.Relicshop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RelicshopService {
    private final RelicshopRepo relicshopRepo;

    public List<Relicshop> fetchAll() {
        return relicshopRepo.findAll();
    }

    public Relicshop fetchById(long id) throws IllegalArgumentException {
        final Optional<Relicshop> maybePerson = relicshopRepo.findById(id);
        if (maybePerson.isEmpty()) {
            throw new IllegalArgumentException("Relicshop not found");
        }
        else {
            return maybePerson.get();
        }
    }

    public long create(String name, long goldPrice, long platinumPrice, String buff, String description)  {
        final Relicshop relicshop = new Relicshop(name, goldPrice, platinumPrice, buff, description);
        final Relicshop savedRelicshop = relicshopRepo.save(relicshop);

        return savedRelicshop.getId();
    }

    public void udpate(long id, String name, long goldPrice, long platinumPrice, String buff, String description)
            throws IllegalArgumentException {
        final Optional<Relicshop> almostRelicshop = relicshopRepo.findById(id);
        if (almostRelicshop.isEmpty()) {
            throw new IllegalArgumentException("Relicshop not found");
        }
        final Relicshop relicshop = almostRelicshop.get();
        if (name != null & !name.isBlank()) {
            relicshop.setRelic_name(name);
        }
        relicshop.setGoldPrice(goldPrice);
        relicshop.setPlatinumPrice(platinumPrice);
        relicshop.setBuff(buff);
        relicshop.setDescription(description);

        relicshopRepo.save(relicshop);
    }

    public void delete(long id) {
        relicshopRepo.deleteById(id);
    }
}
