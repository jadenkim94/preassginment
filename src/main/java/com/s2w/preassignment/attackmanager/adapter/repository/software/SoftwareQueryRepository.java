package com.s2w.preassignment.attackmanager.adapter.repository.software;

import com.s2w.preassignment.attackmanager.domain.Software;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SoftwareQueryRepository {
    Page<Software> findSoftwares(String seedId, Pageable pageable);
}
