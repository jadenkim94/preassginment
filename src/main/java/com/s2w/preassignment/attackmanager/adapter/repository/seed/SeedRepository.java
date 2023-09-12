package com.s2w.preassignment.attackmanager.adapter.repository.seed;

import com.s2w.preassignment.attackmanager.domain.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
    boolean existsBySeedId(String seedId);
}
