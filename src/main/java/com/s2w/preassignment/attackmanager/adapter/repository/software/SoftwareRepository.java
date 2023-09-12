package com.s2w.preassignment.attackmanager.adapter.repository.software;

import com.s2w.preassignment.attackmanager.domain.Software;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<Software, Long>, SoftwareQueryRepository {
    List<Software> findByName(String softwareName);
}
