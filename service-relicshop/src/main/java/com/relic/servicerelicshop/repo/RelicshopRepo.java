package com.relic.servicerelicshop.repo;

import com.relic.servicerelicshop.repo.model.Relicshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelicshopRepo extends JpaRepository<Relicshop, Long> {
}
