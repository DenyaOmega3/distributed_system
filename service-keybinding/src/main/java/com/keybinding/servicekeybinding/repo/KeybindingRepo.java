package com.keybinding.servicekeybinding.repo;

import com.keybinding.servicekeybinding.repo.model.Keybinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeybindingRepo extends JpaRepository<Keybinding, Long> {
}
