package com.s2w.preassignment.attackmanager.adapter.repository.cve;

import com.s2w.preassignment.attackmanager.domain.Cve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CveRepository extends JpaRepository<Cve, Long>, CveQueryRepository {
}
